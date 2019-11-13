package racingcar.domain;

import org.apache.commons.lang3.StringUtils;
import racingcar.exception.IllegalNameException;

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
}
