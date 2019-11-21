package model;

import java.util.Objects;

public class MoveDeterminer {
    private final RandomDigitGenerator generator = new RandomDigitGenerator();
    private final MoveStrategy moveStrategy;

    public MoveDeterminer(final MoveStrategy moveStrategy) {
        Objects.requireNonNull(moveStrategy, "MoveStrategy 는 NULL이 아니어야 합니다.");
        this.moveStrategy = moveStrategy;
    }

    boolean determine() {
        return moveStrategy.canMove(generator.getRandomDigit());
    }
}
