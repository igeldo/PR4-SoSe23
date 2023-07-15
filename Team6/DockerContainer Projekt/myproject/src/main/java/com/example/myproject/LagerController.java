package com.example.myproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lager")
public class LagerController {

    private final LagerRepository lagerRepository;

    @Autowired
    public LagerController(LagerRepository lagerRepository) {
        this.lagerRepository = lagerRepository;
    }

    @GetMapping
    public Iterable<Lager> getAllLager() {
        return lagerRepository.findAll();
    }
}
