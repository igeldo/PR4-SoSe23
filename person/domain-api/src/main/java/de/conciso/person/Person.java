package de.conciso.person;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;
  private String vorname;
  private String name;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return id == person.id && Objects.equals(vorname, person.vorname) && Objects.equals(name, person.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, vorname, name);
  }
}
