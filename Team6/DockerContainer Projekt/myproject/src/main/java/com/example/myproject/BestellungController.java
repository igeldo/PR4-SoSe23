package com.example.myproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bestellung")
public class BestellungController {

    private final BestellungRepository bestellungRepository;

    @Autowired
    public BestellungController(BestellungRepository bestellungRepository) {
        this.bestellungRepository = bestellungRepository;
    }

    @GetMapping
    public Iterable<Bestellung> getAllLager() {
        return bestellungRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> createBestellung(@RequestBody Bestellung bestellung) {
        Bestellung savedBestellung = bestellungRepository.save(bestellung);
        if (savedBestellung != null) {
            return ResponseEntity.ok("Bestellung erfolgreich erstellt");
        } else {
            return ResponseEntity.badRequest().body("Bestellung konnte nicht erstellt werden");
        }
    }
}



