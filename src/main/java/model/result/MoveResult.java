package model.result;

import java.util.Objects;

public class MoveResult {
    private String name;
    private int position;

    public MoveResult(String name, int position) {
        this.name = name;
        this.position = position;
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
