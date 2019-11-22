package com.woowacourse.racingcar.domain.moveStrategy;

public class MoveRandomStrategy implements CarMoveStrategy {

    private static final int MIN_NUM_OF_MOVE = 4;
    private static final int FOR_NATURAL_NUMBER = 10;

    @Override
    public boolean canMove() {
        int randomNumber = (int) (Math.random() * FOR_NATURAL_NUMBER);
        return randomNumber <= MIN_NUM_OF_MOVE;
    }
}
