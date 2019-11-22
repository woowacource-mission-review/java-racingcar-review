package com.woowacourse.racingcar.domain;

import com.woowacourse.racingcar.domain.moveStrategy.CarMoveStrategy;
import com.woowacourse.racingcar.domain.validator.CarsNameValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Cars {

    private static final String CARS_NAME_DELIMITER = ",";
    private final List<Car> cars;

    public Cars(final String carNameWithComma) {
        CarsNameValidator.check(carNameWithComma);
        this.cars = initCars(carNameWithComma);
    }

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(Cars cars) {
        List<Car> args = cars.cars.stream().map(Car::from)
            .collect(Collectors.toList());
        return new Cars(args);
    }

    private static List<Car> initCars(final String carNameWithComma) {
        String[] carsName = carNameWithComma.split(CARS_NAME_DELIMITER);
        return Arrays.stream(carsName).map(String::trim)
            .map(Car::new)
            .collect(toList());
    }

    public List<Car> moveCars(CarMoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
        return cars;
    }

    public int getPositionOf(int index) {
        return cars.get(index).getPosition();
    }

    public int size() {
        return cars.size();
    }

    public Car get(int index) {
        return cars.get(index);
    }

    public List<Car> findWinners() {
        int maxPosition = findWinnerPosition();
        return cars.stream().filter(car -> car.isWinner(maxPosition))
            .collect(Collectors.toList());
    }

    private int findWinnerPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.farThan(maxPosition) ? car.getPosition() : maxPosition;
        }
        return maxPosition;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Cars cars1 = (Cars) o;
        return cars.equals(cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
