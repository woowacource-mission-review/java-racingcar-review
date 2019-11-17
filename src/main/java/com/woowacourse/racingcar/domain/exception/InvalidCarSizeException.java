package com.woowacourse.racingcar.domain.exception;

public class InvalidCarSizeException extends RuntimeException {

    private static final String INVALID_CAR_SIZE_MESSAGE = "자동차 수는 2대 이상이어야 합니다.";

    public InvalidCarSizeException() {
        super(INVALID_CAR_SIZE_MESSAGE);
    }
}
