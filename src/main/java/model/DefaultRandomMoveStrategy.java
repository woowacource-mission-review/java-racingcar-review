package model;

public class DefaultRandomMoveStrategy implements MoveStrategy {
    @Override
    public boolean canMove(Integer seed) {
        return seed >= 4;
    }
}
