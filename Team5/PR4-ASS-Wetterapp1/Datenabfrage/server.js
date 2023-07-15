const express = require("express");
const axios = require("axios");

const app = express();
const port = 2000;
const apiKey = "cdcb25e04a44a30557634680463e0d06";

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

// Datenbank-Microservice URL
const databaseServiceUrl = "http://database-microservice:8080";

// Funktion zum Senden der Daten an den Datenbank-Microservice
async function sendToDatabase(data) {
  try {
    await axios.post(`${databaseServiceUrl}/weather`, data);
    console.log("Daten erfolgreich an den Datenbank-Microservice gesendet.");
  } catch (error) {
    console.error("Fehler beim Senden der Daten an den Datenbank-Microservice:", error.message);
    // Hier könntest du alternative Maßnahmen ergreifen, falls das Senden der Daten fehlschlägt.
    // Zum Beispiel kannst du die Daten lokal speichern oder andere Aktionen durchführen.
  }
}

// Test-Endpunkt für die Kommunikation mit dem Datenbank-Microservice
app.get("/test", (req, res) => {
  res.send("Kommunikation mit dem Datenabfrage-Microservice erfolgreich.");
});

// fragt die Wetterdaten einer Stadt bei der OpenWeatherAPI an
app.get("/weather/city/:city", async (req, res) => {
  const { city } = req.params;
  const url = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}&units=metric`;
  try {
    const response = await axios.get(url);
    const data = response.data;

    // Sende Daten an den Datenbank-Microservice
    await sendToDatabase(data);

    res.json(data);
  } catch (error) {
    console.error(error);
    res.status(500).send("Es ist ein Fehler aufgetreten. Bitte versuchen Sie es später erneut.");
  }
});

// fragt die Wetterdaten anhand der Koordinaten bei der OpenWeatherAPI an
app.get("/weather/coordinates/:lat/:lon", async (req, res) => {
  const { lat, lon } = req.params;
  const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${apiKey}&units=metric`;
  try {
    const response = await axios.get(url);
    const data = response.data;

    // Sende Daten an den Datenbank-Microservice
    await sendToDatabase(data);

    res.json(data);
  } catch (error) {
    console.error(error);
    res.status(500).send("Es ist ein Fehler aufgetreten. Bitte versuchen Sie es später erneut.");
  }
});

app.listen(port, () => {
  console.log(`Microservice listening on port ${port}`);
});
