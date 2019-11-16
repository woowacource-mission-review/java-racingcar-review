package racingcar.exception;

import racingcar.domain.Car;

public class ExcessOfCarNameLengthException extends IllegalArgumentException {

    private static final String EXCESS_OF_CAR_NAME_LENGTH_MESSAGE
            = "자동차 이름의 길이는 " + Car.MIN_OF_CAR_NAME_LENGTH + "자 이하입니다.";

    public ExcessOfCarNameLengthException() {
        super(EXCESS_OF_CAR_NAME_LENGTH_MESSAGE);
    }
}