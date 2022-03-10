package de.conciso.person;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AddressRepresentation {

    String strasse;
    int plz;
    String ort;

    static AddressRepresentation from(Address address) {
        return AddressRepresentation.builder()
            .strasse(address.getStrasse())
            .plz(address.getPlz())
            .ort(address.getOrt())
            .build();
    }
}
