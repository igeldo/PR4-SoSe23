package de.conciso.person;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
public class PersonController {

  private final Personen personen;

  public PersonController(Personen personen) {
    this.personen = personen;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PersonRepresentation> create(
      @RequestBody PersonRepresentation personRepresentation
  ) {
    try {
      var person = personen.create(personRepresentation.toPerson());
      return ResponseEntity.ok(PersonRepresentation.from(person));
    } catch (Exception exception) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @PostMapping(path = "/{id}/address", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PersonRepresentation> addAddress(
      @PathVariable("id") int personId,
      @RequestBody AddressRepresentation addressRepresentation
  ) {
    try {
      return personen.addAddress(personId, addressRepresentation.toAddress())
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
}
