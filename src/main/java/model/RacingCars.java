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
    private List<Car> cars;
    private MoveDeterminer moveDeterminer;

    public RacingCars(List<Car> cars, MoveDeterminer moveDeterminer) {
        validateCars(cars);
        this.cars = cars;
        this.moveDeterminer = moveDeterminer;
    }

    private void validateCars(List<Car> cars) {
        Objects.requireNonNull(cars, "자동차에 NULL을 등록할 수 없습니다.");
        if (cars.size() < 2) {
            throw new InvalidRegistrationException("자동차 경주를 위해 두 대 이상의 자동차가 필요합니다.");
        }
        validateDuplicateNames(cars);
    }

    private void validateDuplicateNames(List<Car> cars) {
        Set<String> carNames = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());
        if (carNames.size() != cars.size()) {
            throw new InvalidRegistrationException("자동차의 이름이 중복됩니다.");
        }
    }

    public RoundResult moveCars() {
        return new RoundResult(cars.stream()
                .map(this::moveCar)
                .collect(Collectors.toList()));
    }

    private MoveResult moveCar(Car car) {
        return car.move(moveDeterminer.determine());
    }

    public WinnerResult calculateWinners() {
        Car winner = Collections.max(cars);
        return new WinnerResult(cars.stream()
                .filter(car -> car.compareTo(winner) == 0)
                .map(Car::getName)
                .collect(Collectors.toList()));
    }
}
