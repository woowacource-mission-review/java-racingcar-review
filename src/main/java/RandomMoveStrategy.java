import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private final static Integer POSSIBLE_MOVE_NUMBER = 4;
    private final static Integer MAX_BOUND_NUMBER = 10;

    @Override
    public boolean canMove() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND_NUMBER) >= POSSIBLE_MOVE_NUMBER;
    }
}
