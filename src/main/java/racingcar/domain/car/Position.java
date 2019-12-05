package racingcar.domain.car;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Position {
    private static final int DEFAULT_CACHE_SIZE = 30;
    static final int UNIT_INCREASE = 1;
    static final int DEFAULT_POSITION = 0;

    private static final Map<Integer, Position> CACHE = new HashMap<>();

    static {
        for (int i = DEFAULT_POSITION; i < DEFAULT_CACHE_SIZE; i += UNIT_INCREASE) {
            CACHE.put(i, new Position(i));
        }
    }

    private final int position;

    private Position(final int position) {
        this.position = position;
    }

    static Position newInstance() {
        return CACHE.get(DEFAULT_POSITION);
    }

    public static Position of(final int position) {
        return get(position);
    }

    Position increase() {
        final int increasedPosition = position + UNIT_INCREASE;
        return get(increasedPosition);
    }

    private static Position get(final int position) {
        return CACHE.getOrDefault(position, create(position));
    }

    private static Position create(final int position) {
        final Position createdPosition = new Position(position);
        CACHE.put(position, createdPosition);
        return createdPosition;
    }

    int getPosition() {
        return position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "position= " + position;
    }
}
