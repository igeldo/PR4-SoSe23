package de.conciso.starter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculate")
public class CalculatorController {

  private static Logger logger = LogManager.getLogger(CalculatorController.class);

  @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE)
  public String calculate(
      @RequestParam("firstNumber") double firstNumber,
      @RequestParam("secondNumber") double secondNumber,
      @RequestParam("operator") char operator
  )  {
    logger.info("calculate: " + firstNumber + " " + operator + " " + secondNumber);

    var calculator = new CalculatorService();
    var result = calculator.calculate(firstNumber, secondNumber, Operator.from(operator));

    logger.info("result: " + result);

    return String.valueOf(result);
  }
}
