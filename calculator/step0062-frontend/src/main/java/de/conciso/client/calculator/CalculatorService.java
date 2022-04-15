package de.conciso.client.calculator;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
public interface CalculatorService {

  @POST
  @Path("/calculate")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  CalculatorResponseRepresentation calculate(CalculatorRequestRepresentation request);
}

