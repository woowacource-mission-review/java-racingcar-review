package com.woowacourse.racingcar.domain.exception;

public class InvalidCarsSizeException extends RuntimeException {

    private static final String INVALID_CAR_SIZE_MESSAGE = "자동차 수는 2대 이상이어야 합니다.";

    public InvalidCarsSizeException() {
        super(INVALID_CAR_SIZE_MESSAGE);
    }
}
