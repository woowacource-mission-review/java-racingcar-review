package model;

public class AlwaysFalseMoveStrategy implements MoveStrategy {
    @Override
    public boolean canMove(int seed) {
        return false;
    }
}
