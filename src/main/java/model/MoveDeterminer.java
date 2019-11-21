package model;

import java.util.Objects;

public class MoveDeterminer {
    private RandomDigitGenerator generator = new RandomDigitGenerator();
    private MoveStrategy moveStrategy;

    public MoveDeterminer(MoveStrategy moveStrategy) {
        Objects.requireNonNull(moveStrategy, "MoveStrategy 는 NULL이 아니어야 합니다.");
        this.moveStrategy = moveStrategy;
    }

    boolean determine() {
        return moveStrategy.canMove(generator.getRandomDigit());
    }
}
