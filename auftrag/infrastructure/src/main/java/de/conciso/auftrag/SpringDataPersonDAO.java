package de.conciso.auftrag;

import org.springframework.data.repository.CrudRepository;

public interface SpringDataPersonDAO extends PersonDAO, CrudRepository<Person, Integer> {
}
