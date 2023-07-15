const express = require('express');
const path = require('path');
const axios = require('axios');

const app = express();
const port = 3000;

// Statische Dateien aus dem "public" Ordner bereitstellen
app.use(express.static(path.join(__dirname, 'public')));

// Alle Anfragen an index.html weiterleiten
app.get('*', (req, res) => {
  res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

// Funktion zum Testen der Kommunikation mit den anderen Containern
async function testContainerCommunication() {
  try {
    // Testanfrage an den Datenabfrage-Container
    const datenabfrageResponse = await axios.get('http://datenabfrage:2000/test');
    console.log('Kommunikation mit Datenabfrage-Container erfolgreich:', datenabfrageResponse.data);

    // Testanfrage an den Datenbank-Microservice-Container
    const databaseResponse = await axios.get('http://database-microservice:8080/test');
    console.log('Kommunikation mit Datenbank-Microservice-Container erfolgreich:', databaseResponse.data);

    console.log('Kommunikationstest erfolgreich abgeschlossen.');
  } catch (error) {
    console.error('Fehler beim Kommunikationstest:', error.message);
  }
}

// Server starten und Kommunikationstest durchführen
app.listen(port, () => {
  console.log(`Frontend ist auf http://localhost:${port} verfügbar.`);
  testContainerCommunication();
});
