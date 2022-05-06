package de.conciso.person;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ort {

  @Id
  private int plz;

  private String ortsName;

  public Ort() {
  }

  public Ort(int plz, String ortsName) {
    this.plz = plz;
    this.ortsName = ortsName;
  }

  public int getPlz() {
    return plz;
  }

  public void setPlz(int plz) {
    this.plz = plz;
  }

  public String getOrtsName() {
    return ortsName;
  }

  public void setOrtsName(String ort) {
    this.ortsName = ort;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Ort address = (Ort) o;
    return plz == address.plz && Objects.equals(ortsName, address.ortsName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plz, ortsName);
  }
}
