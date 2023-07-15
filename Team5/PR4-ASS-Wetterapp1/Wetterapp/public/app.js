const form = document.querySelector("form");
const cityInput = document.querySelector("#city-input");
const wetterErgebnis = document.querySelector("#wetter-ergebnis");
const datenbankErgebnis = document.querySelector("#datenbank-ergebnis");
const dbCityInput = document.querySelector("#db-city-input");

if ("geolocation" in navigator) {
  navigator.geolocation.getCurrentPosition(async (position) => {
    const lat = position.coords.latitude;
    const lon = position.coords.longitude;
    getWetterByCoordinates(lat, lon);
  });
} else {
  alert("Geolocation wird von diesem Browser nicht unterstützt.");
}

form.addEventListener("submit", (e) => {
  e.preventDefault();
  const city = cityInput.value.trim();

  if (city.length === 0) {
    alert("Bitte geben Sie eine Stadt ein.");
    return;
  }

  getWetterByCity(city);
});

const datenbankAbrufenButton = document.querySelector("#datenbank-abrufen");
datenbankAbrufenButton.addEventListener("click", () => {
  const city = dbCityInput.value.trim();
  if (city.length === 0) {
    alert("Bitte geben Sie eine Stadt ein.");
    return;
  }
  getWeatherDataFromDatabase(city);
});

// Anfrage an Wetter Microservice (Stadt)
async function getWetterByCity(city) {
  try {
    const response = await fetch(`http://localhost:2000/weather/city/${city}`);
    const data = await response.json();
    displayWetter(data);
  } catch (error) {
    console.error(error);
    wetterErgebnis.textContent =
        "Es ist ein Fehler aufgetreten. Bitte versuchen Sie es später erneut.";
  }
}

// Anfrage an Wetter Microservice (Koordinaten)
async function getWetterByCoordinates(lat, lon) {
  try {
    const response = await fetch(`http://localhost:2000/weather/coordinates/${lat}/${lon}`);
    const data = await response.json();
    displayWetter(data);
  } catch (error) {
    console.error(error);
    wetterErgebnis.textContent = "Es ist ein Fehler aufgetreten. Bitte versuchen Sie es später erneut.";
  }
}

// Anfrage an Datenbank Microservice
async function getWeatherDataFromDatabase(city) {
  try {
    const response = await fetch(`http://localhost:8080/weather/city/${city}`);
    const data = await response.json();
    displayWeatherDataFromDatabase(data);
  } catch (error) {
    console.error(error);
    wetterErgebnis.textContent =
        "Es ist ein Fehler aufgetreten. Bitte versuchen Sie es später erneut.";
  }
}

// Gibt die Wetterdaten aus
function displayWetter(data) {
  const wetterInfo = `
    <h2>${data.name}, ${data.sys.country}</h2>
    <p>Temperatur: ${data.main.temp}°C</p>
    <p>Luftfeuchtigkeit: ${data.main.humidity}%</p>
    <p>Zeitstempel: ${formatUnixTimestamp(data.dt)}</p>
  `;
  wetterErgebnis.innerHTML = wetterInfo;
}

// Gibt die Wetterdaten aus der Datenbank aus
function displayWeatherDataFromDatabase(data) {
  let wetterInfo = "";
  data.forEach((record) => {
    wetterInfo += `
      <h2>${record.city}</h2>
      <p>Temperatur: ${record.temperature}°C</p>
      <p>Luftfeuchtigkeit: ${record.humidity}%</p>
      <p>Zeitstempel: ${formatUnixTimestamp(record.timestamp)}</p>
      <hr>
    `;
  });
  datenbankErgebnis.innerHTML = wetterInfo;
}

function formatUnixTimestamp(unixTimestamp) {
  const date = new Date(unixTimestamp * 1000); // Konvertiere den Unix-Zeitstempel in Millisekunden
  const formattedDate = date.toLocaleString(); // Verwende die toLocaleString-Methode, um das Datum in ein lesbares Format zu konvertieren
  return formattedDate;
}
