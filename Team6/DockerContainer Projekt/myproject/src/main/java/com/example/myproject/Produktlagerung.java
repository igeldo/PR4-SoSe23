package com.example.myproject;
import jakarta.persistence.*;

@Entity
@Table(name = "produktlagerung")
public class Produktlagerung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produkt_id")
    private long p_id;

    @Column(name = "lager_id")
    private long l_id;

    @Column(name = "menge")
    private long menge;


    public Long getL_Id() {
        return l_id;
    }

    public void setL_id(Long l_id) {
        this.l_id = l_id;
    }

    public Long getP_Id() {
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
