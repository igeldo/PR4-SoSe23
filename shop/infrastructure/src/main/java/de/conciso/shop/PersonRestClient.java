package de.conciso.shop;

import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class PersonRestClient implements Personen {

  private final WebClient personenWebClient;

  public PersonRestClient(WebClient personenWebClient) {
    this.personenWebClient = personenWebClient;
  }

  @Override
  public Person create(Person person) {
    return personenWebClient.post()
        .uri(uriBuilder -> uriBuilder
            .queryParam("vorname", person.getVorname())
            .queryParam("name", person.getName())
            .build()
        )
        .accept(MediaType.APPLICATION_JSON)
        .exchangeToMono(clientResponse -> clientResponse.bodyToMono(PersonRestClientRepresentation.class)
            .map(PersonRestClientRepresentation::toPerson)
        )
        .block();
  }

  @Override
  public Optional<Person> addAddress(int personId, String strasse, int plz, String ort) {
    return personenWebClient.post()
        .uri(uriBuilder -> uriBuilder
            .path("/address")
            .queryParam("personId", personId)
            .queryParam("strasse", strasse)
            .queryParam("plz", plz)
            .queryParam("ort", ort)
            .build()
        )
        .accept(MediaType.APPLICATION_JSON)
        .exchangeToMono(clientResponse -> clientResponse.bodyToMono(PersonRestClientRepresentation.class)
            .map(PersonRestClientRepresentation::toPerson)
            .map(Optional::of)
        )
        .block();
  }

  @Override
  public Optional<Person> findById(int id) {
    return personenWebClient.get()
        .uri(uriBuilder -> uriBuilder.path("/{id}").build(id))
        .accept(MediaType.APPLICATION_JSON)
        .exchangeToMono(clientResponse -> clientResponse.bodyToMono(PersonRestClientRepresentation.class)
            .map(PersonRestClientRepresentation::toPerson)
            .map(Optional::of)
        )
        .block();
  }
}
