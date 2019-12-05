package racingcar.domain.movestrategy;

import racingcar.domain.car.Car;

public interface MoveStrategy {
    boolean isAvailableMove(final Car car);
}
