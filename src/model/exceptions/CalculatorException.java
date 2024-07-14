package model.exceptions;

public class CalculatorException extends RuntimeException {
    public CalculatorException(String errorMsg) {
        super(errorMsg);
    }
}
