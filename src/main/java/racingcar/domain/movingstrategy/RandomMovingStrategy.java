package racingcar.domain.movingstrategy;

public class RandomMovingStrategy implements MovingStrategy {

    private static final double MIN_NUM_FOR_MOVING = 0.4;

    @Override
    public boolean canMove() {
        return Math.random() >= MIN_NUM_FOR_MOVING;
    }
}
