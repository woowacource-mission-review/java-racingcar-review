package racingcar.domain;

import java.util.Random;

public class RandomNumberMoveStrategy implements MoveStrategy {
    private static final int MOVE_BOUNDARY = 4;
    private static final int RANDOM_MAX_BOUNDARY = 9;

    private final Random random = new Random();

    @Override
    public boolean isAvailableMove(final Car car) {
        return random.nextInt(RANDOM_MAX_BOUNDARY + 1) >= MOVE_BOUNDARY;
    }
}
