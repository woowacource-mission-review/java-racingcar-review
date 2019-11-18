package racingcar.domain.car;

import java.util.HashMap;
import java.util.Map;

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

    Position increase() {
        final int increasedPosition = position + UNIT_INCREASE;
        return CACHE.getOrDefault(increasedPosition, create(increasedPosition));
    }

    private Position create(final int position) {
        final Position createdPosition = new Position(position);
        CACHE.put(position, createdPosition);
        return createdPosition;
    }

    int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "position= " + position;
    }
}
