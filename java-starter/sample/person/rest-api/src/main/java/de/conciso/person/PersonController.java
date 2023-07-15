package de.conciso.person;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

  private final Personen personen;

  public PersonController(Personen personen) {
    this.personen = personen;
  }



  @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PersonRepresentation> create(
      @RequestBody PersonRepresentation personRepresentation
  ) {
    Person person;
    try {
      try {
        person = personRepresentation.toPerson();
      }
      catch (Exception exception) {
        return ResponseEntity.badRequest().build();
      }
      person = personen.create(person);
      return ResponseEntity.ok(PersonRepresentation.from(person));
    } catch (Exception exception) {
      return ResponseEntity.internalServerError().header(exception.toString(), exception.toString()).build();
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

  @PutMapping(value = "/{id}/changeLastAddress", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PersonRepresentation> changeLastAddress(
          @PathVariable("id") int id,
          @RequestBody AddressRepresentation addressRepresentation){
    try {
      return personen.changeLastAddress(id, addressRepresentation.toAddress())
              .map(PersonRepresentation::from)
              .map(ResponseEntity::ok)
              .orElseGet(() -> ResponseEntity.notFound().build());
    } catch (Exception exception) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @PutMapping(value = "/{id}/changeAddress/{index}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PersonRepresentation> changeAddress(
          @PathVariable("id") int id,
          @RequestBody AddressRepresentation addressRepresentation,
          @PathVariable("index") int index){
    try {
      return personen.changeAddress(id, addressRepresentation.toAddress(), index)
              .map(PersonRepresentation::from)
              .map(ResponseEntity::ok)
              .orElseGet(() -> ResponseEntity.notFound().build());
    } catch (Exception exception) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @PutMapping(value = "/{id}/changeName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PersonRepresentation> changeName(
          @PathVariable("id") int id,
          @PathVariable("name") String name){
      try {
      return personen.changeName(id, name)
              .map(PersonRepresentation::from)
              .map(ResponseEntity::ok)
              .orElseGet(() -> ResponseEntity.notFound().build());
      } catch (Exception exception) {
      return ResponseEntity.internalServerError().build();
      }
  }

  @PutMapping(value = "/{id}/changeVorname/{vorname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonRepresentation> changeVorname(
            @PathVariable("id") int id,
            @PathVariable("vorname") String vorname){
        try {
        return personen.changeVorname(id, vorname)
                .map(PersonRepresentation::from)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception exception) {
        return ResponseEntity.internalServerError().build();
        }
    }

  @GetMapping(value = "/findId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PersonRepresentation> findById(@PathVariable Integer id) {
    try {
      return personen.findById(id)
          .map(PersonRepresentation::from)
          .map(ResponseEntity::ok)
          .orElseGet(() -> ResponseEntity.notFound().build());
    } catch (Exception exception) {
      return ResponseEntity.internalServerError().build();
    }
  }
  @GetMapping(value = "/findName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PersonRepresentation> findByName(@PathVariable String name) {
    try {
      return personen.findByName(name)
          .map(PersonRepresentation::from)
          .map(ResponseEntity::ok)
          .orElseGet(() -> ResponseEntity.notFound().build());
    } catch (Exception exception) {
      return ResponseEntity.internalServerError().build();
    }
  }
  @GetMapping(value = "/findVorname/{vorname}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PersonRepresentation> findByVorname(@PathVariable String vorname) {
    try {
      return personen.findByVorname(vorname)
          .map(PersonRepresentation::from)
          .map(ResponseEntity::ok)
          .orElseGet(() -> ResponseEntity.notFound().build());
    } catch (Exception exception) {
      return ResponseEntity.internalServerError().build();
    }
  }




  @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<PersonRepresentation>> findAll() { // Hier war Github Copilot überfordert
    /*try {
      return ResponseEntity.ok(PersonRepresentation.from(personen.findAll()));
    } catch (Exception exception) {
      return ResponseEntity.internalServerError().build();
    }*/
    try{
      ArrayList<PersonRepresentation> personRepresentations = new ArrayList<PersonRepresentation>();
        for (Person person : personen.findAll()) {
            ResponseEntity.ok(PersonRepresentation.from(person));
            personRepresentations.add(PersonRepresentation.from(person));
        }
        return ResponseEntity.ok(personRepresentations);
      }
    catch (Exception exception) {
      return ResponseEntity.internalServerError().build();
    }
  }
  @DeleteMapping(value = "/del/{id}")
    public ResponseEntity<PersonRepresentation> deleteById(@PathVariable Integer id) {
        try {
        return personen.deleteById(id)
            .map(PersonRepresentation::from)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception exception) {
        return ResponseEntity.internalServerError().build();
        }
    }

  @GetMapping("/")
  public String home() {
    return "index"; // Name der Startseite (z.B. index.html oder index.jsp)
  }
}
