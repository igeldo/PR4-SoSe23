package com.example.myproject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produkt")
public class ProduktController {

    private final ProduktRepository produktRepository;

    @Autowired
    public ProduktController(ProduktRepository produktRepository) {
        this.produktRepository = produktRepository;
    }

    @GetMapping
    public Iterable<Produkt> getAllProdukte() {
        return produktRepository.findAll();
    }
}

