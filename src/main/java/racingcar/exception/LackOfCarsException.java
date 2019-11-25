package racingcar.exception;

import racingcar.service.RacingCarService;

public class LackOfCarsException extends IllegalArgumentException {

    private static final String LACK_OF_CARS_MESSAGE
            = "자동차의 수는 " + RacingCarService.MIN_NUM_OF_RACING_CARS + "대 이상 입력해 주세요.";

    public LackOfCarsException() {
        super(LACK_OF_CARS_MESSAGE);
    }
}