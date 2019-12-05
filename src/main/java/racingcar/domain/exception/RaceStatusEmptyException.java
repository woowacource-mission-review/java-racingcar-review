package racingcar.domain.exception;

import racingcar.domain.car.Cars;

public class RaceStatusEmptyException extends IllegalStateException {
    public RaceStatusEmptyException() {
        super("CarDto가 비어 있습니다." + Cars.MINIMUM_NAMES + "명 이상이어야 합니다.");
    }
}
