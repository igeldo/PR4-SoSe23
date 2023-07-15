package com.example.myproject;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.*;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.*;

@Component
public class BestellungTrigger {
    /*
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        String triggerQuery = "CREATE TRIGGER bestellungTrigger" +
                "AFTER INSERT ON Bestellung" +
                "FOR EACH ROW" +
                "WHEN (NEW.produkt_id IS NOT NULL)" +
                "EXECUTE FUNCTION pruefe_lagerbestand();" +
                "CREATE OR REPLACE FUNCTION pruefe_lagerbestand()" +
                "RETURNS TRIGGER AS $$" +
                "BEGIN" +
                "    lagerbestand INT;" +
                "    bestellungMenge INT;" +
                "    produktionsMenge INT;" +
                "    lagerbestandMenge INT;" +
                "    SELECT menge INTO bestellungMenge FROM bestellung WHERE produkt_id = NEW.produkt_id;" +
                "    SELECT menge INTO produktionsMenge FROM produktlagerung,bestellung WHERE produktlagerung.produkt_id = bestellung.produkt_id;" +
                "    SELECT menge INTO lagerbestandMenge FROM lagerbestand,produktlagerung WHERE lagerbestand.rohstoff_id = produktlagerung.produkt_id;" +
                "    lagerbestand := lagerbestandMenge - (bestellungMenge * produktionsMenge);" +
                "    IF lagerbestand < 0 THEN" +
                "        RAISE EXCEPTION 'Lagerbestand nicht ausreichend';" +
                "    END IF;" +
                "    RETURN NEW;" +
                "END;" +
                "$$ LANGUAGE plpgsql;";

        try {
            jdbcTemplate.execute(triggerQuery);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
     */
}
