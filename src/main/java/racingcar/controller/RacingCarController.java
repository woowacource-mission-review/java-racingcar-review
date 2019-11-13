package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final RacingCarService racingCarService = new RacingCarService();

    public void run() {
        try {
            String carNames = InputView.inputCarName();
            Cars cars = racingCarService.createCarsByParsingWith(carNames);

        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessageForPlayer(e);
        }
    }
}
