package de.conciso.starter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculate")
public class CalculatorController {

  private static Logger logger = LogManager.getLogger(CalculatorController.class);

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CalculatorResponseRepresentation> calculate(
      @RequestBody CalculatorRequestRepresentation request
  )  {
    logger.info("calculate: " + request.getFirstNumber() + " " + request.getOperator() + " " + request.getSecondNumber());

    var calculator = new CalculatorService();
    var result = calculator.calculate(request.getFirstNumber(), request.getSecondNumber(), Operator.from(request.getOperator()));

    logger.info("result: " + result);

    return ResponseEntity.ok(new CalculatorResponseRepresentation(result));
  }
}
