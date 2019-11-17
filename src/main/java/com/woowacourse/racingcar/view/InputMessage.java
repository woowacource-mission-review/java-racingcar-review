package com.woowacourse.racingcar.view;

public enum InputMessage {

    INPUT_NAME("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
