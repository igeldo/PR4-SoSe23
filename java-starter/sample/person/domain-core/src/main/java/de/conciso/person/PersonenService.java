package de.conciso.person;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonenService implements Personen {

  private static final Logger logger = LogManager.getLogger(PersonenService.class);

  private final PersonDAO personDAO;

  public PersonenService(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  @Override
  public Person create(Person person) {
    logger.info("create person: " + person.getVorname() + " " + person.getName());
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

  @Override
  public Optional<Person> findByName(String name) {
    logger.info("looking for person with name: " + name);
    var found = personDAO.findByName(name);
    if (found.isEmpty()) {
      logger.warn("no person found with name: " + name);
    }
    return found;
  }

  @Override
  public Optional<Person> findByVorname(String vorname) {
    logger.info("looking for person with vorname: " + vorname);
    var found = personDAO.findByVorname(vorname);
    if (found.isEmpty()) {
      logger.warn("no person found with vorname: " + vorname);
    }
    return found;
  }


  @Override
  @Transactional
  public Optional<Person> addAddress(int personId, Address address) {
    logger.info("adding address to person with id: " +personId);
    return findById(personId)
        .map(person -> {
          person.addAddress(address);
          return person;
        });
  }

  @Override
  @Transactional
  public Optional<Person> changeLastAddress(int personId, Address address) {
    logger.info("changing last address to person with id: " +personId);
    return findById(personId)
        .map(person -> {
          person.changeLastAddress(address);
          return person;
        });
  }

  @Override
  @Transactional
  public Optional<Person> changeAddress(int personId, Address address, int addressIndex) {
    logger.info("changing address to person with id: " +personId);
    return findById(personId)
        .map(person -> {
          person.changeAddress(address, addressIndex);
          return person;
        });
  }

  @Override
  @Transactional
  public Optional<Person> changeName(int personId, String name) {
    logger.info("changing name to person with id: " +personId);
    return findById(personId)
        .map(person -> {
          person.setName(name);
          return person;
        });
  }

  @Override
  @Transactional
    public Optional<Person> changeVorname(int personId, String vorname) {
        logger.info("changing vorname to person with id: " +personId);
        return findById(personId)
            .map(person -> {
            person.setVorname(vorname);
            return person;
            });
    }


  @Override
  public List<Person> findAll() {
      logger.info("looking for all persons");
      return personDAO.findAll();
    }

    @Override
    public Optional<Person> deleteById(int id) {
        logger.info("deleting person with id: " + id);
        return findById(id)
            .map(person -> {
            personDAO.deleteById(id);
            return person;
            });
    }



}
