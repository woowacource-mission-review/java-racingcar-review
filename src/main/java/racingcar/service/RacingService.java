package racingcar.service;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.common.RepeatNumber;
import racingcar.domain.movestrategy.MoveStrategy;
import racingcar.domain.race.RaceResult;
import racingcar.domain.race.RaceStatus;
import racingcar.service.dto.CarDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            final List<Car> movedCars = cars.shouldMove(moveStrategy);
            final List<CarDto> carDtos = movedCars.stream().map(CarDto::from).collect(Collectors.toList());
            raceStatuses.add(new RaceStatus(carDtos));
        }

        return new RaceResult(raceStatuses);
    }
}
