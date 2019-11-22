package model.exception;

public class InvalidRegistrationException extends IllegalArgumentException {
    public InvalidRegistrationException(String message) {
        super(message);
    }
}
