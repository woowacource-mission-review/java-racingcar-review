package racingcar.domain;

public interface MoveStrategy {
    boolean isAvailableMove(final Car car);
}
