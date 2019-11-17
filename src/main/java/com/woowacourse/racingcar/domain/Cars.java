package com.woowacourse.racingcar.domain;

import com.woowacourse.racingcar.domain.moveStrategy.CarMoveStrategy;

import java.util.List;
import java.util.Objects;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(CarMoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
    }

    public int getPositionOf(int index) {
        return cars.get(index).getPosition();
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
