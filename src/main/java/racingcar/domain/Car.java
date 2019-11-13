package racingcar.domain;

import racingcar.exception.ExcessOfCarNameLengthException;

public class Car {

    public static final int MIN_OF_CAR_NAME_LENGTH = 5;
    private final Name name;
    private long position;

    public Car(final String name) {
        Name preName = new Name(name);
        if (preName.isLengthLongerThan(MIN_OF_CAR_NAME_LENGTH)) {
            throw new ExcessOfCarNameLengthException();
        }

        this.name = preName;
        this.position = 0;
    }

    public String getName() {
        return name.getName();
    }

    public long getPosition() {
        return position;
    }
}
