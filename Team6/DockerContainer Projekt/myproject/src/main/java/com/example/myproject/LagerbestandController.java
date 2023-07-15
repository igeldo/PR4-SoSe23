package com.example.myproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lagerbestand")
public class LagerbestandController {

    private final LagerbestandRepository lagerbestandRepository;

    @Autowired
    public LagerbestandController(LagerbestandRepository lagerbestandRepository) {
        this.lagerbestandRepository = lagerbestandRepository;
    }

    @GetMapping
    public Iterable<Lagerbestand> getAllLager() {
        return lagerbestandRepository.findAll();
    }
}
