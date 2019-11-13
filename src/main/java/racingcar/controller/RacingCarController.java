package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;

public class RacingCarController {

    private final RacingCarService racingCarService = new RacingCarService();

    public void run() {
        String carNames = InputView.inputCarName();

        Cars cars = racingCarService.createCarsByParsingWith(carNames);
    }
}
