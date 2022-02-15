package de.conciso.starter;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalculatorController {

  @PostMapping (
      value = "/calculate",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<CalculatorRepresentation> calculate(@RequestBody CalculatorRepresentation model) {
    System.out.print("Calculate: " + model.firstNumber + " " + model.currentOperator + " " + model.secondNumber + " = ");
    switch (model.currentOperator) {
      case '+':
        model.result = model.firstNumber + model.secondNumber;
        break;
      case '-':
        model.result = model.firstNumber - model.secondNumber;
        break;
      case '*':
        model.result = model.firstNumber * model.secondNumber;
        break;
      case '/':
        model.result = model.firstNumber / model.secondNumber;
        break;
    }
    System.out.println(model.result);
    return ResponseEntity.ok(model);
  }
}
