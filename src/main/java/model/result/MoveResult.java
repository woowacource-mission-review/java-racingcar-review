package model.result;

import java.util.Objects;

public class MoveResult {
    private final String name;
    private final int position;

    public MoveResult(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoveResult that = (MoveResult) o;
        return position == that.position &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
