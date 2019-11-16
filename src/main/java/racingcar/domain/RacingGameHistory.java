package racingcar.domain;

import com.google.common.collect.Maps;

import java.util.Map;

public class RacingGameHistory {

    private final Map<GameRound, Cars> history = Maps.newHashMap();

    public void record(final GameRound gameRound, final Cars cars) {
        history.put(gameRound, cars);
    }

    public Cars read(final GameRound gameRound) {
        return history.get(gameRound);
    }
}
