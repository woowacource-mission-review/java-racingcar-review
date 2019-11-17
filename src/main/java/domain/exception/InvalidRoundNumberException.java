package domain.exception;

public class InvalidRoundNumberException extends RuntimeException {
    private static final String MESSAGE = "시도 횟수는 1이상의 자연수이어야 합니다.";

    public InvalidRoundNumberException() {
        super(MESSAGE);
    }
}
