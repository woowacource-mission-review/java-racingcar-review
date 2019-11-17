package racingcar.controller;

import racingcar.domain.GameRound;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGameResult;
import racingcar.domain.RandomMovingStrategy;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final RacingCarService racingCarService = new RacingCarService();

    public void run() {
        try {
            String carNames = InputView.inputCarName();
            RacingCars cars = racingCarService.createCarsByParsingWith(carNames);

            String round = InputView.inputGameRound();
            GameRound gameRound = racingCarService.createGameRound(round);

            RacingGameResult result = racingCarService.race(cars, gameRound, new RandomMovingStrategy());
            OutputView.showGameProcess(result);
        } catch (IllegalArgumentException e) {
            OutputView.showExceptionMessageForPlayer(e);
        }
    }
}
