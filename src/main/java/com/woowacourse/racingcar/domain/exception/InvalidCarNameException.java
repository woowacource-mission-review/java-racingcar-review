package com.woowacourse.racingcar.domain.exception;

public class InvalidCarNameException extends RuntimeException {

    private static final String INVALID_CAR_NAME_EXCEPTION = "잘못된 이름입니다. 이름은 5글자 이하 입니다.";

    public InvalidCarNameException() {
        super(INVALID_CAR_NAME_EXCEPTION);
    }
}
