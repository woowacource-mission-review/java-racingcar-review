package racingcar.exception;

public class LackOfCarsException extends IllegalArgumentException {

    public LackOfCarsException(final String message) {
        super(message);
    }
}
