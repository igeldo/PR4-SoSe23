package com.example.myproject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rohstoff")
public class RohstoffController {

    private final RohstoffRepository rohstoffRepository;

    @Autowired
    public RohstoffController(RohstoffRepository rohstoffRepository) {
        this.rohstoffRepository = rohstoffRepository;
    }

    @GetMapping
    public Iterable<Rohstoff> getAllRohstoffe() {
        return rohstoffRepository.findAll();
    }
}

