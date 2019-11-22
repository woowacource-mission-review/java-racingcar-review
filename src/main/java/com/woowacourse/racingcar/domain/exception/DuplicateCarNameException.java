package com.woowacourse.racingcar.domain.exception;

public class DuplicateCarNameException extends RuntimeException {

    private static final String DUPLICATE_CAR_NAME_MESSAGE = "중복된 이름이 존재합니다.";

    public DuplicateCarNameException() {
        super(DUPLICATE_CAR_NAME_MESSAGE);
    }
}
