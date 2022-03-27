package de.conciso.shop;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Person {

  int id;
  String vorname;
  String name;
  List<Address> adresses;
}
