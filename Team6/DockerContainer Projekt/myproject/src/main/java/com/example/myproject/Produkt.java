package com.example.myproject;

import jakarta.persistence.*;


@Entity
@Table(name = "Produkt")
public class Produkt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produkt_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "ort")
    private String ort;

    @Column(name = "preis")
    private long preis;
    // Getter and Setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public long getPreis() {
        return preis;
    }

    public void setPreis(long preis) {
        this.preis = preis;
    }
}