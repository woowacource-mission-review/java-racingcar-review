package racingcar.controller;

import racingcar.domain.RacingGameResult;
import racingcar.domain.car.RacingCars;
import racingcar.domain.gameround.GameRound;
import racingcar.domain.movingstrategy.RandomMovingStrategy;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService = new RacingCarService();

    public RacingCarController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            String carNames = inputView.inputCarName();
            RacingCars cars = racingCarService.createCarsByParsingWith(carNames);

            String round = inputView.inputGameRound();
            GameRound gameRound = racingCarService.createGameRound(round);

            RacingGameResult result = racingCarService.race(cars, gameRound, new RandomMovingStrategy());
            outputView.showGameProcess(result);

            outputView.showWinners(result);
        } catch (IllegalArgumentException e) {
            outputView.showExceptionMessageForPlayer(e);
        }
    }
}
