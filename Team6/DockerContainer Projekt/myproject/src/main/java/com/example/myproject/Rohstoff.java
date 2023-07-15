package com.example.myproject;
import jakarta.persistence.*;

@Entity
@Table(name = "Rohstoff")
public class Rohstoff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rohstoff_id")
    private long r_id;

    @Column(name = "name")
    private String name;

    @Column(name = "gebinde")
    private String gebinde;
    // Getter and Setter methods

    public Long getId() {
        return r_id;
    }

    public void setId(Long id) {
        this.r_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String rohstoffbezeichnung) {
        this.name = rohstoffbezeichnung;
    }

    public String getGebinde() {
        return gebinde;
    }

    public void setGebinde(String gebinde) {
        this.gebinde = gebinde;
    }
}

