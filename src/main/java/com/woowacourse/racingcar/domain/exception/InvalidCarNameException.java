package com.woowacourse.racingcar.domain.exception;

public class InvalidCarNameException extends RuntimeException {

    private static final String INVALID_CAR_NAME_EXCEPTION = "잘못된 이름입니다. 이름은 1~5";

    public InvalidCarNameException() {
        super(INVALID_CAR_NAME_EXCEPTION);
    }
}
