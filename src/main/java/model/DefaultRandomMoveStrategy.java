package model;

public class DefaultRandomMoveStrategy implements MoveStrategy {
    public static final int TRUE_FALSE_BOUNDARY = 4;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 9;

    @Override
    public boolean canMove(final int seed) {
        if (seed < MIN_VALUE || seed > MAX_VALUE) {
            throw new IllegalArgumentException("랜덤 값은 " + MIN_VALUE + " ~ " + MAX_VALUE + " 사이의 정수이어야 합니다.");
        }
        return seed >= TRUE_FALSE_BOUNDARY;
    }
}
