package model;

public class MoveDeterminer {
    private RandomDigitGenerator generator = new RandomDigitGenerator();
    private MoveStrategy moveStrategy;

    public MoveDeterminer(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public boolean determine() {
        return moveStrategy.canMove(generator.getRandomDigit());
    }
}
