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
        .bodyValue(PersonRestClientRepresentation.from(person))
        .accept(MediaType.APPLICATION_JSON)
        .exchangeToMono(clientResponse -> clientResponse.bodyToMono(PersonRestClientRepresentation.class)
            .map(PersonRestClientRepresentation::toPerson)
        )
        .block();
  }

  @Override
  public Optional<Person> addAddress(int personId, Address address) {
    return personenWebClient.post()
        .uri(uriBuilder -> uriBuilder.path("/{id}/address").build(personId))
        .bodyValue(AddressRestClientRepresentation.from(address))
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
