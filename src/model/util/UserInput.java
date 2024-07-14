package model.util;

import model.entities.Calculator;
import model.enums.Operation;
import model.exceptions.UserAnswerException;
import model.exceptions.UserInputException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean exceptionThrown = false;
    private static String personName;

    public static Operation getInputOperation() throws UserInputException {
        try {
            printAvailableOperations();
            if (Calculator.isExceptionWasTriggered()) {
                scanner.nextLine();
            }
            System.out.print("Enter the operation: ");
            Operation op = Operation.valueOf(scanner.nextLine().trim().toUpperCase());
            System.out.println(TextColor.ANSI_GREEN + "Selected: " + TextColor.ANSI_RESET + op);
            return op;
        } catch (IllegalArgumentException e) {
            throw new UserInputException(TextColor.ANSI_RED + "Error: Operation must be one of these: SUM | SUBTRACT | MULTIPLY | DIVIDE." + TextColor.ANSI_RESET);
        }
    }

    public static boolean getExceptionThrown() {
        return exceptionThrown;
    }

    public static double getFirstNumber() throws UserInputException {
        System.out.print("Enter first number: ");
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new UserInputException(TextColor.ANSI_RED + "Error: Number must be a valid value." + TextColor.ANSI_RESET);
        }
    }

    public static double getSecondNumber() throws UserInputException {
        System.out.print("Enter second number: ");
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new UserInputException(TextColor.ANSI_RED + "Error: Number must be a valid value." + TextColor.ANSI_RESET);
        }
    }

    private static void printAvailableOperations() {
        System.out.print(TextColor.ANSI_BOLD + TextColor.ANSI_UNDERLINE + TextColor.ANSI_WHITE + "\nAvailable operations:" + TextColor.ANSI_RESET);
        System.out.println(" SUM | SUBTRACT | MULTIPLY | DIVIDE\n");
    }

    public static void introduceCalculator(String name) {
        System.out.println("\nWelcome to the " + TextColor.ANSI_BLUE + "Calculator " + TextColor.ANSI_RESET + "project, " + name + "!");
    }

    public static void printResult(double number1, double number2, Operation operation) {
        System.out.printf("%n%s%s%s of %s%.2f%s and %s%.2f%s is %s%.2f%s.%n", TextColor.ANSI_PURPLE, operation.toString(), TextColor.ANSI_RESET, TextColor.ANSI_BLUE, number1, TextColor.ANSI_RESET, TextColor.ANSI_BLUE, number2, TextColor.ANSI_RESET, TextColor.ANSI_YELLOW, Calculator.calculate(number1, number2, operation), TextColor.ANSI_RESET);
    }

    public static char wantToContinueProgram() {
        System.out.printf("%nDo you want to %sCONTINUE%s the program? (%sY%s/%sN%s)", TextColor.ANSI_GREEN, TextColor.ANSI_RESET, TextColor.ANSI_GREEN, TextColor.ANSI_RESET, TextColor.ANSI_RED, TextColor.ANSI_RESET);
        System.out.print("\nAnswer: ");
        char answer = scanner.next().toUpperCase().trim().charAt(0);
        scanner.nextLine();
        if (answer != 'Y' && answer != 'N') {
            throw new UserAnswerException(TextColor.ANSI_RED + "Error: Answer must be either 'Y' or 'N'.\nEnding program..." + TextColor.ANSI_RESET);
        }
        if (answer == 'N') {
            System.out.println("\n" + personName + " Calculations: ");
            for (int x = 0; x < Calculator.getCalculations().size(); x++) {
                System.out.println("\n#" + (x + 1) + "\n" + Calculator.getCalculations().get(x));
            }
            System.out.println(TextColor.ANSI_RED + "\nEnding program..." + TextColor.ANSI_RESET);
            scanner.close();
        }
        return answer;
    }

    public static String getPersonName() throws UserInputException {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            exceptionThrown = false;
            personName = name;
            return name;
        }
        exceptionThrown = true;
        throw new UserInputException(TextColor.ANSI_RED + "Error: Name can't be blank." + TextColor.ANSI_RESET);
    }

    public static LocalDate getBirthDate() throws UserInputException {
        System.out.print("Enter your birth date (dd/MM/yyyy): ");
        try {
            String date = scanner.nextLine();
            LocalDate formattedDate = FormatDate.convertToLocalDate(date);
            if(Period.between(formattedDate, LocalDate.now()).getYears() > 100){
                exceptionThrown = true;
                throw new UserInputException(TextColor.ANSI_RED + "Error: You can't inform a date that old." + TextColor.ANSI_RESET);
            }
            exceptionThrown = false;
            return formattedDate;
        }catch(DateTimeParseException e){
            exceptionThrown = true;
            throw new UserInputException(TextColor.ANSI_RED + "Error: Invalid date format." + TextColor.ANSI_RESET);
        }
    }

}
