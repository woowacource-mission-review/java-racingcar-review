package racingcar.domain.race;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.exception.RaceStatusEmptyException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RaceStatus {
    private final List<Car> cars;

    public RaceStatus(final List<Car> cars) {
        if (cars.size() < Cars.MINIMUM_NAMES) {
            throw new RaceStatusEmptyException();
        }
        this.cars = cars;
    }

    public static RaceStatus from(final List<Car> cars) {
        return new RaceStatus(cars);
    }

    public List<Car> getCurrentWinners() {
        final int maxOfPosition = getMaxOfPosition();

        return cars.stream()
                .filter(cars -> cars.matchPosition(maxOfPosition))
                .collect(Collectors.toList());
    }

    private int getMaxOfPosition() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow(RaceStatusEmptyException::new)
                .getPosition();
    }

    public List<Car> getCurrentRaceStatus() {
        return cars;
    }
}
