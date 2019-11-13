package racingcar.domain;

import racingcar.exception.LackOfGameCountException;

import java.util.Objects;

public class GameCount {

    public static final int MIN_NUM_OF_GAME_COUNT = 1;
    private final long count;

    public GameCount(final long count) {
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
        final GameCount gameCount = (GameCount) o;
        return count == gameCount.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
