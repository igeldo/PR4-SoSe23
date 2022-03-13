package de.conciso.shop;

import java.util.List;
import java.util.stream.Collectors;

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

    static List<AddressRepresentation> from(List<Address> addresses) {
        if (addresses == null) {
            return List.of();
        }
        return addresses.stream()
            .map(AddressRepresentation::from)
            .collect(Collectors.toList());
    }
}
