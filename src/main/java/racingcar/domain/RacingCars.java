package racingcar.domain;

import racingcar.exception.WinnerNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCars {

    private List<RacingCar> cars;

    public RacingCars(final List<RacingCar> cars) {
        this.cars = cars;
    }

    public RacingCars(RacingCars racingCars) {
        this(new ArrayList<>());
        for (RacingCar car : racingCars.cars) {
            this.cars.add(new RacingCar(car));
        }
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

    public RacingCars findWinners() {
        RacingCar winner = findOneWinner();
        List<RacingCar> carList = cars.stream()
                .filter(winner::isSamePosition)
                .collect(Collectors.toList());

        return new RacingCars(carList);
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
