package com.woowacourse.racingcar.domain.exception;

public class BlankCarNameException extends RuntimeException {

    private static final String BLANK_CAR_NAME_MESSAGE = "자동차 이름이 비었습니다.(공백 사용 불가)";

    public BlankCarNameException() {
        super(BLANK_CAR_NAME_MESSAGE);
    }
}
