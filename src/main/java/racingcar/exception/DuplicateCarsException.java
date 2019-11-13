package racingcar.exception;

public class DuplicateCarsException extends IllegalArgumentException {

    public static final String DUPLICATE_CARS_MESSAGE = "중복되는 자동차 이름이 있습니다.";

    public DuplicateCarsException() {
        super(DUPLICATE_CARS_MESSAGE);
    }
}
