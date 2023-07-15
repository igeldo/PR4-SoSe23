package com.example.myproject;
import jakarta.persistence.*;

@Entity
@Table(name = "lagerbestand")
public class Lagerbestand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lager_id")
    private Long l_id;

    @Column(name = "rohstoff_id")
    private Long r_id;

    @Column(name = "menge")
    private Long menge;



    public Long getL_Id() {
        return l_id;
    }

    public void setL_id(Long l_id) {
        this.l_id = l_id;
    }

    public Long getR_Id() {
        return r_id;
    }

    public void setR_id(Long r_id) {
        this.r_id = r_id;
    }

    public Long getMenge() {
        return menge;
    }

    public void setMenge(Long menge) {
        this.menge = menge;
    }

}
