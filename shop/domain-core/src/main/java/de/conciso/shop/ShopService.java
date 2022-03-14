package de.conciso.shop;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ShopService implements Shop {

  private static final Logger logger = LogManager.getLogger(ShopService.class);

  private final Personen personen;

  private final Auftraege auftraege;

  public ShopService(Personen personen, Auftraege auftraege) {
    this.personen = personen;
    this.auftraege = auftraege;
  }

  @Override
  public Person createPerson(Person person) {
    logger.info("create person: " + person.getVorname() + " " + person.getName());
    return personen.create(person);
  }

  @Override
  public Optional<Person> addAddress(int personId, Address address) {
    logger.info("adding address to person with id: " + personId);
    return personen.addAddress(personId, address);
  }

  @Override
  public Optional<Person> findPerson(int id) {
    logger.info("looking for person with id: " + id);
    var found = personen.findById(id);
    if (found.isEmpty()) {
      logger.warn("no person found with id: " + id);
    }
    return found;
  }

  public Optional<Auftrag> placeOrder(int personId, String bestellNummer) {
    return personen.findById(personId)
        .filter(person -> !person.getAdresses().isEmpty())
        .flatMap(person -> {
          var address = person.getAdresses().get(0);
          var auftrag = Auftrag.builder()
              .bestellNummer(bestellNummer)
              .lieferadresse(Lieferadresse.builder()
                  .name(person.getVorname() + " " + person.getName())
                  .strasse(address.getStrasse())
                  .plz(address.getPlz())
                  .ort(address.getOrt())
                  .build()
              )
              .build();
          return auftraege.create(auftrag);
        });
  }

  @Override
  public Optional<Auftrag> findAuftrag(int id) {
    logger.info("looking for auftrag with id: " + id);
    var found = auftraege.findById(id);
    if (found.isEmpty()) {
      logger.warn("no auftrag found with id: " + id);
    }
    return found;
  }
}
