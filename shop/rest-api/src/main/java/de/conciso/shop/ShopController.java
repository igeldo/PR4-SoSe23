package de.conciso.shop;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shop")
public class ShopController {

  private final Shop shop;

  public ShopController(Shop shop) {
    this.shop = shop;
  }

  @PostMapping(path = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PersonRepresentation> create(
      @RequestParam("vorname") String vorname,
      @RequestParam("name") String name
  ) {
    try {
      var person = shop.createPerson(vorname, name);
      return ResponseEntity.ok(PersonRepresentation.from(person));
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseEntity.internalServerError().build();
    }
  }

  @PostMapping(path = "/person/address", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PersonRepresentation> addAddress(
      @RequestParam("personId") int personId,
      @RequestParam("strasse") String strasse,
      @RequestParam("plz") int plz,
      @RequestParam("ort") String ort
  ) {
    try {
      return shop.addAddress(personId, strasse, plz, ort)
          .map(PersonRepresentation::from)
          .map(ResponseEntity::ok)
          .orElseGet(() -> ResponseEntity.notFound().build());
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseEntity.internalServerError().build();
    }
  }

  @GetMapping(value = "/person/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PersonRepresentation> findPerson(@PathVariable("id") int id) {
    try {
      return shop.findPerson(id)
          .map(PersonRepresentation::from)
          .map(ResponseEntity::ok)
          .orElseGet(() -> ResponseEntity.notFound().build());
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseEntity.internalServerError().build();
    }
  }

  @PostMapping(path = "/auftrag", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AuftragRepresentation> placeOrder(
      @RequestParam("personId") int personId,
      @RequestParam("bestellnummer") String bestellNummer
  ) {
    try {
      return shop.placeOrder(personId, bestellNummer)
          .map(AuftragRepresentation::from)
          .map(ResponseEntity::ok)
          .orElseGet(() -> ResponseEntity.notFound().build());
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseEntity.internalServerError().build();
    }
  }

  @GetMapping(path = "/auftrag/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AuftragRepresentation> findOrder(@PathVariable("id") int id) {
    try {
      return shop.findAuftrag(id)
          .map(AuftragRepresentation::from)
          .map(ResponseEntity::ok)
          .orElseGet(() -> ResponseEntity.notFound().build());
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseEntity.internalServerError().build();
    }
  }
}
