package com.woowacourse.racingcar.domain.exception;

public class InvalidGameNumberException extends RuntimeException {

    private static final String INVALID_GAME_NUMBER_MESSAGE = "시도 횟수는 1이상 10이하 입니다.";

    public InvalidGameNumberException() {
        super(INVALID_GAME_NUMBER_MESSAGE);
    }
}
