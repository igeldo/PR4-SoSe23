package de.conciso.auftrag;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auftrag")
public class AuftragController {

  private final Auftraege auftraege;

  public AuftragController(Auftraege auftraege) {
    this.auftraege = auftraege;
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AuftragRepresentation> create(@RequestParam("bestellNummer") String bestellNummer) {
    try {
      var auftrag = auftraege.create(bestellNummer);
      return ResponseEntity.ok(AuftragRepresentation.from(auftrag));
    } catch (IllegalArgumentException exception) {
      return ResponseEntity.badRequest().build();
    } catch (Exception exception) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AuftragRepresentation> findById(@PathVariable("id") int id) {
    try {
      return auftraege.findById(id)
          .map(AuftragRepresentation::from)
          .map(ResponseEntity::ok)
          .orElseGet(() -> ResponseEntity.notFound().build());
    } catch (Exception exception) {
      return ResponseEntity.internalServerError().build();
    }
  }
}
