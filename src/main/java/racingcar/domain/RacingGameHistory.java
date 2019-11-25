package racingcar.domain;

import com.google.common.collect.Maps;
import racingcar.domain.car.RacingCars;
import racingcar.domain.gameround.GameRound;

import java.util.Map;
import java.util.Set;

public class RacingGameHistory {

    private final Map<GameRound, RacingCars> history = Maps.newHashMap();

    public void record(final GameRound gameRound, final RacingCars cars) {
        history.put(gameRound, cars);
    }

    public RacingCars read(final GameRound gameRound) {
        return RacingCars.of(history.get(gameRound));
    }

    public long getNumOfGameRounds() {
        Set<GameRound> gameRounds = history.keySet();
        return gameRounds.size();
    }
}
