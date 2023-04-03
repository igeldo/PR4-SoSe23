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
    System.out.print("Calculate: " + model.getFirstNumber() + " " + model.getCurrentOperator() + " " + model.getSecondNumber() + " = ");
    switch (model.getCurrentOperator()) {
      case '+':
        model.setResult(model.getFirstNumber() + model.getSecondNumber());
        break;
      case '-':
        model.setResult(model.getFirstNumber() - model.getSecondNumber());
        break;
      case '*':
        model.setResult(model.getFirstNumber() * model.getSecondNumber());
        break;
      case '/':
        model.setResult(model.getFirstNumber() / model.getSecondNumber());
        break;
    }
    System.out.println(model.getResult());
    return ResponseEntity.ok(model);
  }
}
