package model.exception;

public class InvalidRoundException extends IllegalArgumentException {
    public InvalidRoundException(String message) {
        super(message);
    }
}
