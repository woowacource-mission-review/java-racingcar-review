package model;

import model.exception.InvalidRegistrationException;
import model.result.MoveResult;
import model.result.RoundResult;
import model.result.WinnerResult;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingCars {
    private static final Integer MIN_CARS_SIZE = 2;

    private final List<Car> cars;
    private final MoveDeterminer moveDeterminer;

    public RacingCars(final List<Car> cars, final MoveDeterminer moveDeterminer) {
        validateCars(cars);
        this.cars = cars;
        this.moveDeterminer = moveDeterminer;
    }

    private void validateCars(final List<Car> cars) {
        Objects.requireNonNull(cars, "자동차에 NULL을 등록할 수 없습니다.");
        if (cars.size() < MIN_CARS_SIZE) {
            throw new InvalidRegistrationException("자동차 경주를 위해 " + MIN_CARS_SIZE + " 대 이상의 자동차가 필요합니다.");
        }
        validateDuplicateNames(cars);
    }

    private void validateDuplicateNames(final List<Car> cars) {
        Set<String> carNames = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());
        if (carNames.size() != cars.size()) {
            throw new InvalidRegistrationException("자동차의 이름이 중복됩니다.");
        }
    }

    public RoundResult playOneRound() {
        return new RoundResult(cars.stream()
                .map(this::tryMove)
                .collect(Collectors.toList()));
    }

    private MoveResult tryMove(final Car car) {
        return car.tryMove(moveDeterminer);
    }

    public WinnerResult calculateWinners() {
        Car winner = Collections.max(cars);
        return new WinnerResult(cars.stream()
                .filter(car -> car.compareTo(winner) == 0)
                .map(Car::getName)
                .collect(Collectors.toList()));
    }
}
