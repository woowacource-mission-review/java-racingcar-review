package model;

import model.exception.CarCreateException;
import model.exception.InvalidRegistrationException;
import model.result.MoveResult;
import model.result.RoundResult;
import model.result.WinnerResult;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<Car> cars;
    private MoveDeterminer moveDeterminer;

    public RacingCars(List<Car> cars, MoveDeterminer moveDeterminer) {
        validateCars(cars);
        validateMoveDeterminer(moveDeterminer);
        this.cars = cars;
        this.moveDeterminer = moveDeterminer;
    }

    private void validateCars(List<Car> cars) {
        if (cars == null) {
            throw new CarCreateException("자동차에 NULL을 등록할 수 없습니다.");
        }
        if (cars.size() == 0) {
            throw new CarCreateException("차 이름을 입력해주세요.");
        }
    }

    private void validateMoveDeterminer(MoveDeterminer moveDeterminer) {
        if (moveDeterminer == null) {
            throw new InvalidRegistrationException("MoveDeterminer 가 Null 입니다.");
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
