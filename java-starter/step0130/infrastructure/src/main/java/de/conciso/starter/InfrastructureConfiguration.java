package de.conciso.starter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class InfrastructureConfiguration {

  @Bean
  public WebClient auftrageWebClient() {
    return WebClient.builder()
        .baseUrl("http://auftrag:8080/api/auftrag")
        .build();
  }
}
