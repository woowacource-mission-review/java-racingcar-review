package racingcar.domain;

import racingcar.exception.ExcessOfCarNameLengthException;

import java.util.Objects;

public class Car {

    public static final int MIN_OF_CAR_NAME_LENGTH = 5;
    private final Name name;
    private long position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, final long position) {
        Name preName = new Name(name);
        if (preName.isLengthLongerThan(MIN_OF_CAR_NAME_LENGTH)) {
            throw new ExcessOfCarNameLengthException();
        }

        this.name = preName;
        this.position = position;
    }

    public String getName() {
        return name.getName();
    }

    public long getPosition() {
        return position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.canMove()) {
            position++;
        }
    }
}
