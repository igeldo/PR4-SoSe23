package com.example.myproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produktlagerung")
public class ProduktlagerungController {

    private final ProduktlagerungRepository produktlagerungRepository;

    @Autowired
    public ProduktlagerungController(ProduktlagerungRepository produktlagerungRepository) {
        this.produktlagerungRepository = produktlagerungRepository;
    }

    @GetMapping
    public Iterable<Produktlagerung> getAllLager() {
        return produktlagerungRepository.findAll();
    }
}
