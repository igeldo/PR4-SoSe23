package de.conciso.starter;

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
  public ResponseEntity<PersonRepresentation> create(@RequestParam("vorname") String vorname,
                                       @RequestParam("name") String name) {
    try {
      var person = personen.create(vorname, name);
      return ResponseEntity.ok(PersonRepresentation.from(person));
    } catch (IllegalArgumentException exception) {
      return ResponseEntity.badRequest().build();
    } catch (Exception exception) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Person> findById(@PathVariable("id") int id) {
    try {
      var found = personen.findById(id);
      return found.map(ResponseEntity::ok)
          .orElseGet(() -> ResponseEntity.notFound().build());
    } catch (Exception exception) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Person> findByRequestParam(@RequestParam("id") int id) {
    return findById(id);
  }
}
