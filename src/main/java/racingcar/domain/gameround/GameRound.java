package racingcar.domain.gameround;

import racingcar.exception.LackOfGameCountException;

import java.util.Objects;

public class GameRound {

    public static final long MIN_NUM_OF_GAME_ROUND = 1;
    private final long roundNum;

    GameRound(final long roundNum) {
        if (roundNum < MIN_NUM_OF_GAME_ROUND) {
            throw new LackOfGameCountException();
        }

        this.roundNum = roundNum;
    }

    public long getRoundNum() {
        return roundNum;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final GameRound gameRound = (GameRound) o;
        return roundNum == gameRound.roundNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundNum);
    }
}
