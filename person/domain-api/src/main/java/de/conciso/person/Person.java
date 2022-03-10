package de.conciso.person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Person {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;

  private String vorname;
  private String name;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "personId", referencedColumnName = "id")
  private List<Address> addresses = new ArrayList<>();

  public Person() {
  }

  public Person(String vorname, String name) {
    this.vorname = vorname;
    this.name = name;
  }

  public Person(int id, String vorname, String name) {
    this.id = id;
    this.vorname = vorname;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getVorname() {
    return vorname;
  }

  public void setVorname(String vorname) {
    this.vorname = vorname;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Address> getAddresses() {
    return Collections.unmodifiableList(addresses);
  }

  public void addAddress(Address address) {
    addresses.add(address);
  }
}
