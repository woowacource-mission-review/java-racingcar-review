package racingcar.domain;

import racingcar.domain.car.RacingCar;
import racingcar.domain.car.RacingCars;
import racingcar.domain.gameround.GameRoundPool;

import java.util.List;

public class RacingGameResult {

    private final RacingGameHistory history;

    public RacingGameResult(final RacingGameHistory history) {
        this.history = history;
    }

    public RacingCars read(final long round) {
        return history.read(GameRoundPool.of(round));
    }

    public long getNumOfGameRounds() {
        return history.getNumOfGameRounds();
    }

    public List<RacingCar> findWinners() {
        long numOfGameRounds = history.getNumOfGameRounds();
        RacingCars cars = read(numOfGameRounds);

        return cars.findWinners();
    }
}
