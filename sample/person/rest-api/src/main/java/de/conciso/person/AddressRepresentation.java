package de.conciso.person;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.jms.artemis.ArtemisAutoConfiguration;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AddressRepresentation {

    String strasse;
    int plz;
    String ort;

    public Address toAddress() {
        return new Address(strasse, plz, ort);
    }

    public static AddressRepresentation from(Address address) {
        return AddressRepresentation.builder()
            .strasse(address.getStrasse())
            .plz(address.getPlz())
            .ort(address.getOrt())
            .build();
    }

    public static List<AddressRepresentation> from(List<Address> addresses) {
        return addresses.stream()
            .map(AddressRepresentation::from)
            .collect(Collectors.toList());
    }
}
