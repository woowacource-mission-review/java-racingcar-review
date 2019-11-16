package racingcar.domain;

public class Position {
    private static final int UNIT_INCREASE = 1;
    static final int DEFAULT_POSITION = 0;

    private final int position;

    private Position(final int position) {
        this.position = position;
    }

    static Position newInstance() {
        return new Position(DEFAULT_POSITION);
    }

    Position increase() {
        return new Position(position + UNIT_INCREASE);
    }

    int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "position= " + position;
    }
}
