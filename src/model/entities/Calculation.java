package model.entities;

import model.enums.Operation;

public class Calculation {
    private Double number1;
    private Double number2;
    private Operation operation;

    private Double result;

    public Calculation(double number1, double number2, Operation operation) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
    }

    public Double getNumber1() {
        return number1;
    }

    public Double getNumber2() {
        return number2;
    }

    public Operation getOperation() {
        return operation;
    }

    public double getResult(Operation op){
        return switch (op) {
            case SUM -> number1+number2;
            case SUBTRACT -> number1-number2;
            case MULTIPLY -> number1*number2;
            case DIVIDE -> number1/number2;
        };
    }

    public String toString() {
        return "Numbers (input order):\n" +"  • "+ String.format("%.2f",getNumber1()) + "\n  • "
                + String.format("%.2f",getNumber2()) + "\nOperation: " + getOperation() + "\nResult: " + String.format("%.2f",getResult(operation));
    }

}
