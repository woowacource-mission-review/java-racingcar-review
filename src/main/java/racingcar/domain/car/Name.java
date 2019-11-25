package racingcar.domain.car;

import org.apache.commons.lang3.StringUtils;
import racingcar.exception.IllegalNameException;

import java.util.Objects;

public class Name {

    private final String innerName;

    public Name(final String innerName) {
        if (StringUtils.isBlank(innerName)) {
            throw new IllegalNameException();
        }

        this.innerName = innerName;
    }

    public String getInnerName() {
        return innerName;
    }

    public boolean isLengthLongerThan(final int length) {
        return innerName.length() > length;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Name name1 = (Name) o;
        return Objects.equals(innerName, name1.innerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(innerName);
    }
}
