package com.example.myproject;
import jakarta.persistence.*;

@Entity
@Table(name = "bestellung")
public class Bestellung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kunde")
    private String kunde;

    @Column(name = "produkt_id")
    private Long p_id;

    @Column(name = "menge")
    private Long menge;


    public String getKunde() {
        return kunde;
    }

    public void setKunde(String id) {
        this.kunde = kunde;
    }

    public Long getP_id() {
        return p_id;
    }

    public void setP_id(Long p_id) {
        this.p_id = p_id;
    }

    public Long getMenge() {
        return menge;
    }

    public void setMenge(Long menge) {
        this.menge = menge;
    }
}