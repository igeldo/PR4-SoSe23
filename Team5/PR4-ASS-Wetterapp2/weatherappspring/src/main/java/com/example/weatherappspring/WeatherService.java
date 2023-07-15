package com.example.weatherappspring;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class WeatherService {

    private final String apiKey = "e1c3a805c8d99f6d1125d336fc87d33a"; // Füge hier deinen eigenen API-Schlüssel ein

    public WeatherData getWeatherData(String city) throws IOException, URISyntaxException {
        HttpClient httpClient = HttpClients.createDefault();

        // Erstelle die API-URL mit der gewünschten Stadt und dem API-Schlüssel
        URIBuilder uriBuilder = new URIBuilder("https://api.openweathermap.org/data/2.5/weather");
        uriBuilder.addParameter("q", city);
        uriBuilder.addParameter("appid", apiKey);

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        String responseBody = httpClient.execute(httpGet, response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                return EntityUtils.toString(response.getEntity());
            } else {
                throw new IOException("Fehler beim Abrufen der API-Daten. Statuscode: " + status);
            }
        });

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode json = objectMapper.readTree(responseBody);

        // Extrahiere die benötigten Daten aus der JSON-Antwort und erstelle eine WeatherData-Instanz
        WeatherData weatherData = new WeatherData();
        weatherData.setCity(json.get("name").asText());

        double temperatureKelvin = json.get("main").get("temp").asDouble();
        double temperatureCelsius = temperatureKelvin - 273.15; // Umrechnung von Kelvin in Grad Celsius

        // Runde die Temperatur auf eine Dezimalstelle genau
        double roundedTemperature = Math.round(temperatureCelsius * 10.0) / 10.0;

        weatherData.setTemperature(roundedTemperature);
        weatherData.setDescription(json.get("weather").get(0).get("description").asText());

        return weatherData;
    }
}

