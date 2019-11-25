package racingcar.exception;

public class IllegalNameException extends IllegalArgumentException {

    private static final String ILLEGAL_NAME_MESSAGE = "잘못된 입력(공백 등)의 이름이 있습니다.";

    public IllegalNameException() {
        super(ILLEGAL_NAME_MESSAGE);
    }
}
