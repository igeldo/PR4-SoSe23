public class Model {

    private double firstNumber,secondNumber,result;

    private char currentOperator;

    public double getFirstNumber() { return firstNumber; }
    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }
    public double getSecondNumber() {
        return secondNumber;
    }
    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }
    public double getResult() { return result; }
    public void setResult(double result) {
        this.result = result;
    }
    public void setCurrentOperator(char op) {
        this.currentOperator = op;
    }
    public char getCurrentOperator() {
        return currentOperator;
    }

    public void reset () {
        this.firstNumber = 0;
        this.secondNumber = 0;
        this.result = 0;
    }
}
