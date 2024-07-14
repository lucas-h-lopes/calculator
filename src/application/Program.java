package application;

import model.enums.Operation;
import model.exceptions.CalculatorException;
import model.exceptions.UserAnswerException;
import model.exceptions.UserInputException;
import model.util.UserInput;

import java.util.Locale;

public class Program {
    public static void main(String[] args) throws UserInputException {
        Locale.setDefault(Locale.US);
        UserInput.introduceCalculator();
        char answer = ' ';
        do {

            try {
                Operation operation = UserInput.getInputOperation();
                System.out.println();

                double number1 = UserInput.getFirstNumber();
                double number2 = UserInput.getSecondNumber();

                UserInput.printResult(number1, number2, operation);
                answer = UserInput.wantToContinueProgram();

            } catch (UserInputException | CalculatorException e) {
                System.out.println("\n" + e.getMessage());
            } catch (UserAnswerException e) {
                System.out.println(e.getMessage());
                break;
            }
        } while (answer != 'N');

    }

}
