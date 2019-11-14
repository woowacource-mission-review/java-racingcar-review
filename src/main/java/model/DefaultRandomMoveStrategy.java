package model;

public class DefaultRandomMoveStrategy implements MoveStrategy {
    @Override
    public boolean canMove(int seed) {
        return seed >= 4;
    }
}
