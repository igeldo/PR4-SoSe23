package de.conciso.person;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

  /**
   * Registers the KeycloakAuthenticationProvider with the authentication manager.
   */
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) {
    auth.authenticationProvider(keycloakAuthenticationProvider());
  }

  /*
   * Defines the session authentication strategy.
   *
   * https://www.keycloak.org/docs/latest/securing_apps/#_spring_security_adapter
   * You must provide a session authentication strategy bean which should be of type
   * RegisterSessionAuthenticationStrategy for public or confidential applications and
   * NullAuthenticatedSessionStrategy for bearer-only applications.
   */
  @Bean
  @Override
  protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
    return new NullAuthenticatedSessionStrategy();
  }

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    super.configure(httpSecurity);

    httpSecurity
        .csrf().disable() // tokens are immune to csrf
        .httpBasic().disable() // not relevant so disable it
        .formLogin().disable() // not relevant so disable it
        // setting this so the authentication provider will always reevaluate the token
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    httpSecurity.authorizeRequests().antMatchers("/api/**").permitAll();
    // httpSecurity.authorizeRequests().antMatchers("/api/**").authenticated();
  }
}
