package com.woowacourse.racingcar.domain;

import com.woowacourse.racingcar.domain.moveStrategy.CarMoveStrategy;
import com.woowacourse.racingcar.domain.validator.CarNameValidator;

import java.util.Objects;

public class Car {

    private final String name;
    private int position = 0;

    public Car(final String name) {
        CarNameValidator.check(name);
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void move(CarMoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            this.position++;
        }
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
