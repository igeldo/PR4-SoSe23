package de.conciso.auftrag;

import org.springframework.data.repository.CrudRepository;

public interface SpringDataAuftragDAO extends AuftragDAO, CrudRepository<Auftrag, Integer> {
}
