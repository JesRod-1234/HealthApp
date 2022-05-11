package se.iths.HealthApp.Exception;

public class EmailAlreadyExist extends RuntimeException{

    public EmailAlreadyExist(String message){
        super(message);
    }
}
