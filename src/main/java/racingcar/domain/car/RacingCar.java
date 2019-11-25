package racingcar.domain.car;

import racingcar.domain.movingstrategy.MovingStrategy;

import java.util.Objects;

public class RacingCar implements Comparable<RacingCar> {

    private static final int INITIAL_POSITION = 0;

    private final RacingCarName name;
    private long position;

    public RacingCar(final String name) {
        this(name, INITIAL_POSITION);
    }

    public RacingCar(final String name, final long position) {
        this.name = new RacingCarName(name);
        this.position = position;
    }

    public RacingCar(RacingCar car) {
        this(car.name.getName(), car.position);
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.canMove()) {
            position++;
        }
    }

    public boolean isSamePosition(RacingCar car) {
        return compareTo(car) == 0;
    }

    public String getAlignedName() {
        return name.getAlignedName();
    }

    public String getName() {
        return name.getName();
    }

    public long getPosition() {
        return position;
    }

    @Override
    public int compareTo(final RacingCar car) {
        return Long.compare(this.position, car.position);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final RacingCar car = (RacingCar) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
