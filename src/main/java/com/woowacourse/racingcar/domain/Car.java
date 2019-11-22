package com.woowacourse.racingcar.domain;

import com.woowacourse.racingcar.domain.moveStrategy.CarMoveStrategy;
import com.woowacourse.racingcar.domain.validator.CarNameValidator;

import java.util.Objects;

public class Car {

    private final String name;
    private int position;

    public Car(final String name) {
        CarNameValidator.check(name);
        this.name = name;
        this.position = 0;
    }

    private Car(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(Car car) {
        return new Car(car.name, car.position);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position;
    }

    public void move(final CarMoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            this.position++;
        }
    }

    public boolean farThan(final int position) {
        return this.position > position;
    }

    public boolean isWinner(final int maxPosition) {
        return position == maxPosition;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Car car = (Car) o;
        return position == car.position &&
            name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
