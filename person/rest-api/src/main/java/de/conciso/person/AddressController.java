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
@RequestMapping("/api/address")
public class AddressController {

  private final Personen personen;

  public AddressController(Personen personen) {
    this.personen = personen;
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AddressRepresentation> create(
      @RequestParam("personId") int personId,
      @RequestParam("strasse") String strasse,
      @RequestParam("plz") int plz,
      @RequestParam("ort") String ort
  ) {
    try {
      return personen.create(personId, strasse, plz, ort)
          .map(AddressRepresentation::from)
          .map(ResponseEntity::ok)
          .orElseGet(() -> ResponseEntity.notFound().build());
    } catch (IllegalArgumentException exception) {
      return ResponseEntity.badRequest().build();
    } catch (Exception exception) {
      return ResponseEntity.internalServerError().build();
    }
  }
}
