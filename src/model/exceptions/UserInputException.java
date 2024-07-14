package model.exceptions;

public class UserInputException extends Exception{
    public UserInputException(String errorMsg){
        super(errorMsg);
    }
}
