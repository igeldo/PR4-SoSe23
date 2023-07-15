<template>
    <div class="weather-app">
        <h1>Wetter-App 2</h1>
        <div class="weather-section">
            <div class="weather-actions">
                <input v-model="city" type="text" placeholder="Stadt eingeben" class="city-input">
                <div class="button-container">
                    <button @click="getWeatherData" class="weather-button">Wetterdaten abrufen</button>
                    <button @click="saveWeatherData" class="weather-button">Wetterdaten speichern</button>
                    <button @click="getWeatherDataFromDatabase" class="weather-button">Datenbank abfragen</button>
                </div>
            </div>
            <div v-if="loading" class="loading-message">Daten werden geladen...</div>
            <div v-if="currentWeatherData" class="current-weather">
                <h2>Aktuelles Wetter für {{ currentCity }}</h2>
                <p>Temperatur: {{ currentWeatherData.temperature }}°C</p>
                <p>Beschreibung: {{ currentWeatherData.description }}</p>
            </div>
            <div v-if="successMessage" class="success-message">{{ successMessage }}</div>
            <div v-if="errorMessage" class="error-message">{{ errorMessage }}</div>
            <div v-if="databaseWeatherData" class="database-weather">
                <h2>Wetterdaten aus der Datenbank für {{ databaseCity }}</h2>
                <div class="database-results">
                    <div v-if="databaseWeatherData.length > 0">
                        <div v-for="data in databaseWeatherData" :key="data.id" class="database-data">
                            <p>Temperatur: {{ data.temperature }}°C</p>
                            <p>Beschreibung: {{ data.description }}</p>
                            <p>Zeitstempel (UTC): {{ formatTimestamp(data.timestamp) }}</p>
                            <hr>
                        </div>
                    </div>
                    <div v-else>
                        <p>Keine Wetterdaten in der Datenbank gefunden.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            city: '',
            currentCity: '',
            currentWeatherData: null,
            loading: false,
            successMessage: '',
            errorMessage: '',
            databaseWeatherData: null,
            databaseCity: ''
        };
    },
    methods: {
        getWeatherData() {
            this.loading = true;
            this.successMessage = '';
            this.errorMessage = '';

            axios.get(`http://localhost:2345/weather/${this.city}`)
                .then(response => {
                    this.currentCity = this.city;
                    this.currentWeatherData = response.data;
                    this.loading = false;
                })
                .catch(error => {
                    console.error(error);
                    this.errorMessage = 'Fehler beim Abrufen der Wetterdaten.';
                    this.loading = false;
                });
        },
        saveWeatherData() {
            this.loading = true;
            this.successMessage = '';
            this.errorMessage = '';

            axios.post('http://localhost:8080/weather', this.currentWeatherData)
                .then(response => {
                    console.log('Wetterdaten wurden gespeichert.');
                    this.successMessage = 'Wetterdaten wurden gespeichert.';
                    this.loading = false;
                })
                .catch(error => {
                    console.error(error);
                    this.errorMessage = 'Fehler beim Speichern der Wetterdaten.';
                    this.loading = false;
                });
        },
        getWeatherDataFromDatabase() {
            this.loading = true;
            this.successMessage = '';
            this.errorMessage = '';

            axios.get(`http://localhost:8080/weather/${this.city}`)
                .then(response => {
                    this.databaseCity = this.city;
                    this.databaseWeatherData = response.data;
                    this.loading = false;
                })
                .catch(error => {
                    console.error(error);
                    this.errorMessage = 'Fehler beim Abrufen der Wetterdaten aus der Datenbank.';
                    this.loading = false;
                });
        },
        formatTimestamp(timestamp) {
            const date = new Date(timestamp);
            return date.toLocaleString();
        }
    }
};
</script>

<style>
.weather-app {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    min-height: 100vh;
    font-family: Arial, sans-serif;
    background-color: #f5f5f5;
    margin: 0 auto;
    width: 100%;
    max-width: 500px;
    padding: 20px;
}


h1 {
    color: orange;
}

.weather-section {
    display: flex;
    flex-direction: column;
    align-items: center;
    max-width: 500px;
    width: 100%;
    padding: 20px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

.weather-actions {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 20px;
    width: 100%;
}

.city-input {
    padding: 5px;
    margin-bottom: 10px;
    width: 100%;
}

.button-container {
    display: flex;
    justify-content: space-between;
    width: 100%;
}

.weather-button {
    padding: 5px 10px;
    cursor: pointer;
    background-color: orange;
    color: #fff;
    border: none;
    border-radius: 5px;
}

.loading-message,
.success-message,
.error-message {
    margin-bottom: 10px;
    text-align: center;
    color: orange;
}

.current-weather,
.database-weather {
    margin-bottom: 20px;
    text-align: center;
}

.database-results {
    max-height: 200px;
    overflow-y: auto;
}

.database-data {
    margin-bottom: 10px;
    padding-bottom: 5px;
    border-bottom: 1px solid #ccc;
}

</style>
