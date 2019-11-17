package com.woowacourse.racingcar.view;

public enum InputMessage {

    INPUT_NAME("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    INPUT_TRY_NUMBER("시도할 회수는 몇회인가요?");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}