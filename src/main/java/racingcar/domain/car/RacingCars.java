package racingcar.domain.car;

import racingcar.domain.movingstrategy.MovingStrategy;
import racingcar.exception.DuplicateCarsException;
import racingcar.exception.LackOfCarsException;
import racingcar.exception.WinnerNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCars {

    public static final int MIN_NUM_OF_RACING_CARS = 2;

    private List<RacingCar> cars;

    public RacingCars(final List<RacingCar> cars) {
        if (isNotEnoughCars(cars)) {
            throw new LackOfCarsException();
        }

        if (hasDuplicateNamesIn(cars)) {
            throw new DuplicateCarsException();
        }

        this.cars = cars;
    }

    private boolean isNotEnoughCars(final List<RacingCar> cars) {
        return cars.size() < MIN_NUM_OF_RACING_CARS;
    }

    private boolean hasDuplicateNamesIn(final List<RacingCar> cars) {
        Set<RacingCar> nameSet = new HashSet<>(cars);

        return cars.size() != nameSet.size();
    }

    public static RacingCars of(RacingCars racingCars) {
        List<RacingCar> cars = new ArrayList<>();
        for (RacingCar car : racingCars.cars) {
            cars.add(new RacingCar(car));
        }
        return new RacingCars(cars);
    }

    public RacingCar get(int index) {
        return cars.get(index);
    }

    public int size() {
        return cars.size();
    }

    public boolean contains(final RacingCar car) {
        return cars.contains(car);
    }

    public void move(MovingStrategy movingStrategy) {
        for (RacingCar car : cars) {
            car.move(movingStrategy);
        }
    }

    public List<RacingCar> findWinners() {
        RacingCar winner = findOneWinner();
        return cars.stream()
                .filter(winner::isSamePosition)
                .collect(Collectors.toList());
    }

    private RacingCar findOneWinner() {
        return cars.stream()
                .max(RacingCar::compareTo)
                .orElseThrow(WinnerNotFoundException::new);
    }

    public Stream<RacingCar> stream() {
        return cars.stream();
    }
}
