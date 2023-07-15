const express = require("express");
const bodyParser = require("body-parser");
const { Pool } = require("pg");

const app = express();
const port = 8080;

// umgeht die CORS Richtlinien
app.use((req, res, next) => {
    res.setHeader("Access-Control-Allow-Origin", "*");
    res.setHeader(
        "Access-Control-Allow-Headers",
        "Origin, X-Requested-With, Content-Type, Accept"
    );
    res.setHeader("Access-Control-Allow-Methods", "GET, POST, PATCH, DELETE");
    next();
});

// PostgreSQL-Datenbankverbindung konfigurieren
const pool = new Pool({
    user: "postgres",
    host: "postgresql",
    database: "weatherdata",
    password: "de46503",
    port: 5432 // Standard-Port für PostgreSQL
});

// Middleware für das Parsen von JSON-Anfragen einrichten
app.use(bodyParser.json());

// Tabellenerstellung mit Retry-Mechanismus
const createTable = async () => {
    let retries = 5;
    while (retries > 0) {
        try {
            const createTableQuery = `
        CREATE TABLE IF NOT EXISTS weatherdata (
          id SERIAL PRIMARY KEY,
          city VARCHAR(255) NOT NULL,
          temperature NUMERIC(5,2) NOT NULL,
          humidity NUMERIC(5,2) NOT NULL,
          timestamp BIGINT -- Ändern des Feldtyps auf BIGINT für Zahlendarstellung des Zeitstempels
        );
      `;

            await pool.query(createTableQuery);
            console.log("Table 'weatherdata' created or already exists.");
            break; // Exit the retry loop if the table creation is successful
        } catch (error) {
            console.error("Error creating 'weatherdata' table:", error);
            retries--;
            console.log(`Retrying table creation. Retries left: ${retries}`);
            await new Promise((resolve) => setTimeout(resolve, 2000)); // Wait for 2 seconds before retrying
        }
    }
};


createTable(); // Create the table when the server starts

// Wetterdaten in die Datenbank einfügen
app.post("/weather", async (req, res) => {
    const weatherData = req.body;

    try {
        const query = "INSERT INTO weatherdata (city, temperature, humidity, timestamp) VALUES ($1, $2, $3, $4)";
        const values = [weatherData.name, weatherData.main.temp, weatherData.main.humidity, weatherData.dt];

        await pool.query(query, values);

        res.sendStatus(200);
    } catch (error) {
        console.error(error);
        res.status(500).send("Es ist ein Fehler aufgetreten. Bitte versuchen Sie es später erneut.");
    }
});

// Daten für eine bestimmte Stadt abrufen
app.get("/weather/city/:city", async (req, res) => {
    const { city } = req.params;

    try {
        const query = "SELECT * FROM weatherdata WHERE city = $1";
        const values = [city];

        const result = await pool.query(query, values);
        const weatherData = result.rows;

        res.json(weatherData);
    } catch (error) {
        console.error(error);
        res.status(500).send("Es ist ein Fehler aufgetreten. Bitte versuchen Sie es später erneut.");
    }
});

// Test-Endpunkt für die Kommunikation mit der Datenabfrage
app.get("/test", (req, res) => {
    res.send("Kommunikation mit dem Datenbank-Microservice erfolgreich.");
});

app.listen(port, () => {
    console.log(`Database Microservice listening on port ${port}`);
});
