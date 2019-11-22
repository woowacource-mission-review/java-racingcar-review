package controller;

import model.DefaultRandomMoveStrategy;
import model.RacingCarGame;
import model.result.GameResult;
import view.InputView;
import view.OutputView;

public class RacingGameController {
    private static final int INITIAL_REPEAT_COUNT = 0;

    private InputView inputView;
    private OutputView outputView;
    private RacingCarGame racingCarGame;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarGame = new RacingCarGame(new DefaultRandomMoveStrategy());
    }

    public void start() {
        registerCar(INITIAL_REPEAT_COUNT);
        registerRound(INITIAL_REPEAT_COUNT);
        GameResult gameResult = racingCarGame.startGame();
        showResult(gameResult);
    }

    private void showResult(GameResult gameResult) {
        outputView.showResults(gameResult);
    }

    private boolean registerCar(final int repeatCount) {
        try {
            return racingCarGame.registerCar(inputView.inputCarNames(repeatCount));
        } catch (IllegalArgumentException | NullPointerException e) {
            outputView.showErrorMessage(e);
            return registerCar(repeatCount + 1);
        }
    }

    private boolean registerRound(final int repeatCount) {
        try {
            return racingCarGame.registerRound(inputView.inputRound(repeatCount));
        } catch (IllegalArgumentException | NullPointerException e) {
            outputView.showErrorMessage(e);
            return registerRound(repeatCount + 1);
        }
    }
}
