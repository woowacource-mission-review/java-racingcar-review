package model;

public class DefaultRandomMoveStrategy implements MoveStrategy {
    @Override
    public boolean canMove(int seed) {
        if (seed < 0 || seed > 9) {
            throw new IllegalArgumentException("랜덤 값은 0 ~ 9 사이의 정수이어야 합니다.");
        }
        return seed >= 4;
    }
}
