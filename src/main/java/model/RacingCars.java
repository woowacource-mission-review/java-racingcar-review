package model;

import model.exception.CarCreateException;
import model.exception.InvalidRegistrationException;

import java.util.List;

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

    public void moveCars() {
        for (Car car : cars) {
            car.move(moveDeterminer.determine());
        }
    }
}
