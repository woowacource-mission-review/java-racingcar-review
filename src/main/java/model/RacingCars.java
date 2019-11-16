package model;

import model.exception.CarCreateException;

import java.util.List;

public class RacingCars {
    private List<Car> cars;

    public RacingCars(List<Car> cars) {
        validateCars(cars);
        this.cars = cars;
    }

    private void validateCars(List<Car> cars) {
        if (cars == null) {
            throw new CarCreateException("NULL을 등록할 수 없습니다.");
        }
        if (cars.size() == 0) {
            throw new CarCreateException("차 이름을 입력해주세요.");
        }
    }
}
