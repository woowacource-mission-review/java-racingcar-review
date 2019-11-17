package controller;

import model.DefaultRandomMoveStrategy;
import model.MoveDeterminer;
import model.RacingCarGame;
import model.result.GameResult;
import view.InputView;
import view.OutputView;

public class RacingGameController {
    private InputView inputView;
    private OutputView outputView;
    private RacingCarGame racingCarGame;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarGame = new RacingCarGame(new MoveDeterminer(new DefaultRandomMoveStrategy()));
    }

    public void start() {
        registerCar();
        registerRound();
        GameResult gameResult = racingCarGame.startGame();
        showResult(gameResult);
    }

    private void showResult(GameResult gameResult) {
        outputView.showResults(gameResult);
    }

    private boolean registerCar() {
        try {
            return racingCarGame.registerCar(inputView.inputCarNames());
        } catch (RuntimeException e) {
            outputView.showErrorMessage(e);
            return registerCar();
        }
    }

    private boolean registerRound() {
        try {
            return racingCarGame.registerRound(inputView.inputRound());
        } catch (RuntimeException e) {
            outputView.showErrorMessage(e);
            return registerRound();
        }
    }
}
