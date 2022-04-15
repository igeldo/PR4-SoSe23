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

  private final Calculator calculator;

  public CalculatorController(Calculator calculator) {
    this.calculator = calculator;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CalculatorResponseRepresentation> calculate(
      @RequestBody CalculatorRequestRepresentation request
  )  {
    try {
      logger.info("calculate: " + request.getFirstNumber() + " " + request.getOperator() + " " + request.getSecondNumber());
      var result = calculator.calculate(request.getFirstNumber(), request.getSecondNumber(), Operator.from(request.getOperator()));
      logger.info("result: " + result);
      return ResponseEntity.ok(new CalculatorResponseRepresentation(result));
    } catch ( IllegalArgumentException exception) {
      logger.warn(exception.getMessage());
      return ResponseEntity.badRequest().build();
    } catch (Exception exception) {
      logger.error(exception.getMessage());
      return ResponseEntity.internalServerError().build();
    }
  }
}
