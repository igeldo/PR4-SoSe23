package de.conciso.client.calculator;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
public interface CalculatorService {

  @POST
  @Path("/calculate")
  @Produces(MediaType.TEXT_PLAIN)
  String calculate(
      @QueryParam("firstNumber") double firstNumber,
      @QueryParam("secondNumber") double secondNumber,
      @QueryParam("operator") char operator
  );
}

