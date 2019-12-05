package racingcar.domain.car;

import racingcar.domain.movestrategy.MoveStrategy;

import java.util.Objects;


public class Car {
    private final Name name;
    private final Position position;

    private Car(final String name) {
        this(name, Position.newInstance());
    }

    private Car(final String name, final int position) {
        this(name, Position.of(position));
    }

    public Car(final String name, final Position position) {
        this.name = Name.of(name);
        this.position = position;
    }

    public static Car of(final String name) {
        return new Car(name);
    }

    public static Car of(final String name, final int position) {
        return new Car(name, position);
    }

    Car tryMove(final MoveStrategy moveStrategy) {
        if (moveStrategy.isAvailableMove(this)) {
            return new Car(name.getName(), position.increase());
        }
        return new Car(name.getName(), position);
    }

    public boolean matchPosition(final int position) {
        return this.position.getPosition() == position;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Car car = (Car) o;
        return Objects.equals(name, car.name) &&
                Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
