package de.conciso.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class InfrastructureConfiguration {

  @Bean
  public WebClient auftrageWebClient(@Value("${service.auftrag.url}") String url) {
    return WebClient.builder()
        .baseUrl(url)
        .build();
  }

  @Bean
  public WebClient personenWebClient(@Value("${service.person.url}") String url) {
    return WebClient.builder()
        .baseUrl(url)
        .build();
  }
}
