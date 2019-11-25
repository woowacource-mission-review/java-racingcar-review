package racingcar.domain.car;

import org.apache.commons.lang3.StringUtils;
import racingcar.exception.ExcessOfCarNameLengthException;

import java.util.Objects;

public class RacingCarName {

    public static final int MIN_OF_CAR_NAME_LENGTH = 5;

    private final Name carName;

    public RacingCarName(final String carName) {
        Name preName = new Name(carName);
        if (preName.isLengthLongerThan(MIN_OF_CAR_NAME_LENGTH)) {
            throw new ExcessOfCarNameLengthException();
        }

        this.carName = preName;
    }

    public String getName() {
        return carName.getInnerName();
    }

    public String getAlignedName() {
        return StringUtils.rightPad(carName.getInnerName(), MIN_OF_CAR_NAME_LENGTH);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final RacingCarName that = (RacingCarName) o;
        return Objects.equals(carName, that.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
