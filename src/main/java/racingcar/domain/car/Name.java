package racingcar.domain.car;

import java.util.Objects;

public class Name {
    private static final int MAX_BOUNDARY = 5;
    private static final int MIN_BOUNDARY = 2;

    private final String name;

    private Name(final String name) {
        if (name.length() > MAX_BOUNDARY || name.length() < MIN_BOUNDARY) {
            throw new IllegalArgumentException("이름은 2~5자로 해주세요.");
        }
        this.name = name;
    }

    static Name of(final String name) {
        return new Name(name);
    }

    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return "name= " + name;
    }
}
