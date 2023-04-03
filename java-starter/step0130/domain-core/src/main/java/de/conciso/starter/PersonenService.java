package de.conciso.starter;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class PersonenService implements Personen {

  private static final Logger logger = LogManager.getLogger(PersonenService.class);

  private final PersonDAO personDAO;

  private final Auftraege auftraege;

  public PersonenService(PersonDAO personDAO, Auftraege auftraege) {
    this.personDAO = personDAO;
    this.auftraege = auftraege;
  }

  @Override
  public Person create(String vorname, String name) {
    logger.info("create person: " + vorname + " " + name);

    try {
      var auftrag = auftraege.create(Auftrag.builder().bestellNummer("Hugo").build());
      logger.info("created auftrag: " + auftrag.getBestellNummer());
    } catch (Exception e) {
      e.printStackTrace();
    }

    var person = new Person(vorname, name);
    return personDAO.save(person);
  }

  @Override
  public Optional<Person> findById(int id) {
    logger.info("looking for person with id: " + id);
    var found = personDAO.findById(id);
    if (found.isEmpty()) {
      logger.warn("no person found with id: " + id);
    }
    return found;
  }
}
