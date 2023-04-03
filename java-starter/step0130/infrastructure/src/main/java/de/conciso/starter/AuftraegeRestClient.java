package de.conciso.starter;

import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AuftraegeRestClient implements Auftraege {

  private WebClient webClient;

  public AuftraegeRestClient(WebClient webClient) {
    this.webClient = webClient;
  }

  @Override
  public Auftrag create(Auftrag auftrag) {
    return webClient.post()
        .uri(uriBuilder -> uriBuilder.queryParam("bestellNummer", auftrag.getBestellNummer()).build())
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(AuftragRepresentation.from(auftrag))
        .exchangeToMono(clientResponse -> clientResponse.bodyToMono(AuftragRepresentation.class)
            .map(auftragRepresentation -> Auftrag.builder()
                .bestellNummer(auftragRepresentation.getName())
                .build()
            )
        )
        .block();
  }

  @Override
  public Optional<Auftrag> find(int id) {
    return Optional.empty();
  }
}
