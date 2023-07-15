package com.example.myproject;
import jakarta.persistence.*;

@Entity
@Table(name = "lager")
public class Lager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lager_id")
    private Long id;
    @Column(name ="ort")
    private String ort;
    @Column(name = "menge")
    private Long menge;

    // Getter and Setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public Long getMenge() {
        return menge;
    }

    public void setMenge(Long menge) {
        this.menge = menge;
    }
}

