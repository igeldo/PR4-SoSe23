package de.conciso.shop;

import static org.springframework.http.HttpStatus.OK;

import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class AuftraegeRestClient implements Auftraege {

  private final WebClient auftrageWebClient;

  public AuftraegeRestClient(WebClient auftrageWebClient) {
    this.auftrageWebClient = auftrageWebClient;
  }

  @Override
  public Auftrag create(Auftrag auftrag) {
    return auftrageWebClient.post()
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(AuftragRestClientRepresentation.from(auftrag))
        .exchangeToMono(clientResponse -> clientResponse.bodyToMono(AuftragRestClientRepresentation.class)
            .map(AuftragRestClientRepresentation::toAuftrag)
        )
        .block();
  }

  @Override
  public Optional<Auftrag> findById(int id) {
    return auftrageWebClient.get()
        .uri(uriBuilder -> uriBuilder.path("/{id}").build(id))
        .accept(MediaType.APPLICATION_JSON)
        .exchangeToMono(this::processResponse)
        .block();
  }

  private Mono<Optional<Auftrag>> processResponse(ClientResponse response) {
    if (response.statusCode().equals(OK)) {
      return response.bodyToMono(AuftragRestClientRepresentation.class)
          .map(AuftragRestClientRepresentation::toAuftrag)
          .map(Optional::of);
    } else {
      return Mono.just(Optional.empty());
    }
  }
}
