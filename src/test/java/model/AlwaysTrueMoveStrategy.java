package model;

public class AlwaysTrueMoveStrategy implements MoveStrategy {
    @Override
    public boolean canMove(int seed) {
        return true;
    }
}
