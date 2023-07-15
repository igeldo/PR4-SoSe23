package com.example.weatherdb;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

/**
 * Der WeatherDataController bietet Endpunkte für das Speichern und Abrufen von Wetterdaten.
 */
@RestController
@RequestMapping("/weather")
@CrossOrigin(origins = "http://localhost:5173")
public class WeatherDataController {
    private final WeatherDataRepository weatherDataRepository;

    public WeatherDataController(WeatherDataRepository weatherDataRepository) {
        this.weatherDataRepository = weatherDataRepository;
    }

    /**
     * Speichert Wetterdaten in der Datenbank.
     *
     * @param weatherData die zu speichernden Wetterdaten
     * @return die gespeicherten Wetterdaten
     */
    @PostMapping
    public ResponseEntity<WeatherData> saveWeatherData(@RequestBody WeatherData weatherData) {
        weatherData.setTimestamp(LocalDateTime.now(ZoneOffset.UTC));// Aktuellen Zeitpunkt setzen
        WeatherData savedData = weatherDataRepository.save(weatherData);
        return ResponseEntity.ok(savedData);
    }


    /**
     * Ruft Wetterdaten für eine bestimmte Stadt ab.
     *
     * @param city der Name der Stadt
     * @return eine Liste von Wetterdaten für die angegebene Stadt
     */
    @GetMapping("/{city}")
    public ResponseEntity<List<WeatherData>> getWeatherDataByCity(@PathVariable String city) {
        List<WeatherData> weatherDataList = weatherDataRepository.findByCity(city);
        return ResponseEntity.ok(weatherDataList);
    }
}
