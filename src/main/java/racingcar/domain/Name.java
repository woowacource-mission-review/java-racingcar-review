package racingcar.domain;

import org.apache.commons.lang3.StringUtils;
import racingcar.exception.IllegalNameException;

import java.util.Objects;

public class Name {

    private final String name;

    public Name(final String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalNameException();
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isLengthLongerThan(final int length) {
        return name.length() > length;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
