package com.woowacourse.racingcar.domain;

public class RacingGame {

    private final Cars cars;
    private final GameNumber gameNumber;

    public RacingGame(final Cars cars, final GameNumber gameNumber) {
        this.cars = cars;
        this.gameNumber = gameNumber;
    }
}
