package de.conciso.auftrag;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class AuftraegeService implements Auftraege {

  private static final Logger logger = LogManager.getLogger(AuftraegeService.class);

  private final AuftragDAO auftragDAO;

  public AuftraegeService(AuftragDAO auftragDAO) {
    this.auftragDAO = auftragDAO;
  }

  @Override
  public Auftrag create(Auftrag auftrag) {
    logger.info("create auftrag: " + auftrag.getBestellNummer());
    return auftragDAO.save(auftrag);
  }

  @Override
  public Optional<Auftrag> findById(int id) {
    logger.info("looking for auftrag with id: " + id);
    var found = auftragDAO.findById(id);
    if (found.isEmpty()) {
      logger.warn("no auftrag found with id: " + id);
    }
    return found;
  }
}
