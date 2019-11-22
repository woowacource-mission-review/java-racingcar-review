package model.exception;

public class CarCreateException extends IllegalArgumentException {
    public CarCreateException(String message) {
        super(message);
    }
}
