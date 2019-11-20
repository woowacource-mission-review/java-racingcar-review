package racingcar.service;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.common.RepeatNumber;
import racingcar.domain.movestrategy.MoveStrategy;
import racingcar.domain.race.RaceResult;
import racingcar.domain.race.RaceStatus;

import java.util.ArrayList;
import java.util.List;

public class RacingService {
    private final MoveStrategy moveStrategy;

    public RacingService(final MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public Cars createCars(final String names) {
        return new Cars(names);
    }

    public RaceResult startRace(final int number, final Cars cars) {
        final RepeatNumber repeatNumber = RepeatNumber.from(number);

        final List<RaceStatus> raceStatuses = new ArrayList<>();
        for (int i = 0; i < repeatNumber.getNumber(); i++) {
            final List<Car> movedCars = cars.tryMove(moveStrategy);
            raceStatuses.add(new RaceStatus(movedCars));
        }

        return new RaceResult(raceStatuses);
    }
}
