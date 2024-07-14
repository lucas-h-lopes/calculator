package application;

import model.entities.Person;
import model.enums.Operation;
import model.exceptions.CalculatorException;
import model.exceptions.UserAnswerException;
import model.exceptions.UserInputException;
import model.util.FormatDate;
import model.util.UserInput;

import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        char answer = ' ';
        Person person = new Person();

        do {
            try {
                System.out.println();
                person.setName(UserInput.getPersonName());
                person.setBirthDate(UserInput.getBirthDate());
            } catch (UserInputException e) {
                System.out.println("\n" + e.getMessage());
            }
        } while (UserInput.getExceptionThrown());

        UserInput.introduceCalculator(person.getName());
        FormatDate.printDateInformation();
        System.out.println("You are " + person.getAge() + " years old.");
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
