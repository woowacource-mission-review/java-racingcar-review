package racingcar.domain;

import com.google.common.collect.Maps;

import java.util.Map;

public class RacingGameHistory {

    private final Map<GameRound, RacingCars> history = Maps.newHashMap();

    public void record(final GameRound gameRound, final RacingCars cars) {
        history.put(gameRound, cars);
    }

    public RacingCars read(final GameRound gameRound) {
        return history.get(gameRound);
    }
}
