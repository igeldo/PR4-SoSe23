package de.conciso.person;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
public class PersonController {

  private final Personen personen;

  public PersonController(Personen personen) {
    this.personen = personen;
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PersonRepresentation> create(
      @RequestParam("vorname") String vorname,
      @RequestParam("name") String name
  ) {
    try {
      var person = personen.create(vorname, name);
      return ResponseEntity.ok(PersonRepresentation.from(person));
    } catch (Exception exception) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @PostMapping(path = "/address", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PersonRepresentation> addAddress(
      @RequestParam("personId") int personId,
      @RequestParam("strasse") String strasse,
      @RequestParam("plz") int plz,
      @RequestParam("ort") String ort
  ) {
    try {
      return personen.addAddress(personId, strasse, plz, ort)
          .map(PersonRepresentation::from)
          .map(ResponseEntity::ok)
          .orElseGet(() -> ResponseEntity.notFound().build());
    } catch (Exception exception) {
      return ResponseEntity.internalServerError().build();
    }
  }


  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PersonRepresentation> findById(@PathVariable("id") int id) {
    try {
      return personen.findById(id)
          .map(PersonRepresentation::from)
          .map(ResponseEntity::ok)
          .orElseGet(() -> ResponseEntity.notFound().build());
    } catch (Exception exception) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PersonRepresentation> findByRequestParam(@RequestParam("id") int id) {
    return findById(id);
  }
}
