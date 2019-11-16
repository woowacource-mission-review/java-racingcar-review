package racingcar.domain;

import racingcar.exception.LackOfGameCountException;

import java.util.Objects;

public class GameRound {

    public static final int MIN_NUM_OF_GAME_COUNT = 1;
    private final long count;

    public GameRound(final long count) {
        if (count < MIN_NUM_OF_GAME_COUNT) {
            throw new LackOfGameCountException();
        }

        this.count = count;
    }

    public long getCount() {
        return count;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final GameRound gameRound = (GameRound) o;
        return count == gameRound.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
