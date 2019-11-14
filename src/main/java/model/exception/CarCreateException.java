package model.exception;

public class CarCreateException extends RuntimeException {
    public CarCreateException() {
    }

    public CarCreateException(String message) {
        super(message);
    }

    public CarCreateException(Throwable cause) {
        super(cause);
    }
}
