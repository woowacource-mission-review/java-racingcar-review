package racingcar.domain;

public class Car {
    private final Name name;
    private Position position;

    public Car(final String name) {
        this.name = Name.of(name);
        this.position = Position.newInstance();
    }

    public static Car of(final String name) {
        return new Car(name);
    }

    public void shouldMove(final MoveStrategy moveStrategy) {
        if (moveStrategy.isAvailableMove(this)) {
            position = position.increase();
        }
    }

    public boolean isSamePosition(int position) {
        return getPosition() == position;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
