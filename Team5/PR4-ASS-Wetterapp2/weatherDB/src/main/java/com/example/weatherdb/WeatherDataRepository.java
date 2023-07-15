package com.example.weatherdb;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Das WeatherDataRepository bietet Methoden zum Speichern, Lesen und Löschen von Wetterdaten in der Datenbank.
 */
public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {

    /**
     * Sucht nach Wetterdaten für eine bestimmte Stadt in der Datenbank.
     *
     * @param city der Name der Stadt
     * @return eine Liste von Wetterdaten für die angegebene Stadt
     */
    List<WeatherData> findByCity(String city);
}

