package com.woowacourse.racingcar.domain;

import com.google.common.collect.Lists;
import com.woowacourse.racingcar.domain.moveStrategy.CarMoveStrategy;
import com.woowacourse.racingcar.domain.validator.CarsNameValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class Cars {

    private static final String CARS_NAME_DELIMITER = ",";
    private final List<Car> cars;

    public Cars(final String carNameWithComma) {
        CarsNameValidator.check(carNameWithComma);
        this.cars = initCars(carNameWithComma);
    }

    public Cars(final Cars cars) {
        this.cars= Lists.newArrayList();
        cars.getCars().forEach(car -> this.cars.add(new Car(car.getName())));
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

    public List<Car> getCars() {
        return this.cars;
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
