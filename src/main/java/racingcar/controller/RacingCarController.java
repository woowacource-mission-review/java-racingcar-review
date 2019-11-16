package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.GameRound;
import racingcar.domain.RacingGameResult;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final RacingCarService racingCarService = new RacingCarService();

    public void run() {
        try {
            String carNames = InputView.inputCarName();
            Cars cars = racingCarService.createCarsByParsingWith(carNames);

            String round = InputView.inputGameRound();
            GameRound gameRound = racingCarService.createGameRound(round);

            RacingGameResult result = racingCarService.race(cars, gameRound);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessageForPlayer(e);
        }
    }
}
