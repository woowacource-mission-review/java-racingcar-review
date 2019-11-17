package domain.exception;

public class CarNameLengthExcessException extends RuntimeException {
    private static final String MESSAGE = "자동차 이름은 5글자를 초과할 수 없습니다.";

    public CarNameLengthExcessException() {
        super(MESSAGE);
    }
}
