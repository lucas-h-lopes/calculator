package model.exceptions;

public class UserAnswerException extends RuntimeException{
    public UserAnswerException(String errorMsg){
        super(errorMsg);
    }
}
