package com.woowacourse.racingcar.domain;

import com.woowacourse.racingcar.domain.moveStrategy.CarMoveStrategy;

public class RacingGame {

    private static final int START_ROUND = 1;
    private final Cars cars;
    private final GameNumber gameNumber;

    public RacingGame(final String carsNameWithComma, final int gameNumber) {
        this.cars = new Cars(carsNameWithComma);
        this.gameNumber = new GameNumber(gameNumber);
    }

    public GameResult play(final CarMoveStrategy moveStrategy) {
        GameResult result = new GameResult();
        GameNumber nowGameNumber = new GameNumber(START_ROUND);

        while (nowGameNumber.isNotEquals(gameNumber)) {
            cars.moveCars(moveStrategy);
            result.addResult(new Cars(cars));
            nowGameNumber.plusOne();
        }
        return result;
    }
}
