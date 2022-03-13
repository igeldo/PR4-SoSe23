package de.conciso.shop;

import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AuftraegeRestClient implements Auftraege {

  private final WebClient auftrageWebClient;

  public AuftraegeRestClient(WebClient auftrageWebClient) {
    this.auftrageWebClient = auftrageWebClient;
  }

  @Override
  public Optional<Auftrag> create(Auftrag auftrag) {
    return auftrageWebClient.post()
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(AuftragRestClientRepresentation.from(auftrag))
        .exchangeToMono(clientResponse -> clientResponse.bodyToMono(AuftragRestClientRepresentation.class)
            .map(AuftragRestClientRepresentation::toAuftrag)
            .map(Optional::of)
        )
        .block();
  }

  @Override
  public Optional<Auftrag> findById(int id) {
    return auftrageWebClient.get()
        .uri(uriBuilder -> uriBuilder.path("/{id}").build(id))
        .accept(MediaType.APPLICATION_JSON)
        .exchangeToMono(clientResponse -> clientResponse.bodyToMono(AuftragRestClientRepresentation.class)
            .map(AuftragRestClientRepresentation::toAuftrag)
            .map(Optional::of)
        )
        .block();
  }
}
