package model.entities;

import model.enums.Operation;
import model.exceptions.CalculatorException;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static boolean exceptionWasTriggered;

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    private static final List<Calculation> calculations = new ArrayList<>();

    public static List<Calculation> getCalculations() {
        return calculations;
    }

    public static boolean isExceptionWasTriggered(){
        return exceptionWasTriggered;
    }

    public static Double calculate(double number1, double number2, Operation op) throws CalculatorException {
        return switch (op) {
            case SUM -> sum(number1, number2);
            case SUBTRACT -> subtract(number1, number2);
            case MULTIPLY -> multiply(number1, number2);
            case DIVIDE -> divide(number1, number2);
        };
    }

    protected static double sum(double number1, double number2) {
        calculations.add(new Calculation(number1, number2, Operation.SUM));
        exceptionWasTriggered = false;
        return number1 + number2;
    }

    protected static double subtract(double number1, double number2) {
        calculations.add(new Calculation(number1, number2,Operation.SUBTRACT));
        exceptionWasTriggered = false;
        return number1 - number2;
    }

    protected static double multiply(double number1, double number2) {
        calculations.add(new Calculation(number1, number2, Operation.MULTIPLY));
        exceptionWasTriggered = false;
        return number1 * number2;
    }

    protected static double divide(double number1, double number2) throws CalculatorException {
        if (number2 == 0) {
            exceptionWasTriggered = true;
            throw new CalculatorException(ANSI_RED + "Error: The 2° number can't be zero." + ANSI_RESET);
        }
        calculations.add(new Calculation(number1, number2, Operation.DIVIDE));
        exceptionWasTriggered = false;
        return number1 / number2;
    }
}
