package racingcar.domain.car;

import org.apache.commons.lang3.StringUtils;
import racingcar.domain.movingstrategy.MovingStrategy;
import racingcar.exception.ExcessOfCarNameLengthException;

import java.util.Objects;

public class RacingCar implements Comparable<RacingCar> {

    public static final int MIN_OF_CAR_NAME_LENGTH = 5;

    private final Name name;
    private long position;

    public RacingCar(final String name) {
        this(name, 0);
    }

    public RacingCar(final String name, final long position) {
        Name preName = new Name(name);
        if (preName.isLengthLongerThan(MIN_OF_CAR_NAME_LENGTH)) {
            throw new ExcessOfCarNameLengthException();
        }

        this.name = preName;
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
        return StringUtils.rightPad(name.getName(), MIN_OF_CAR_NAME_LENGTH);
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
