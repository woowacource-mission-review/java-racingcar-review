package model;

import model.exception.InvalidRegistrationException;
import model.result.GameResult;
import model.result.RoundResults;

public class RacingCarGame {
    private final MoveDeterminer moveDeterminer;
    private RacingCars racingCars;
    private Round round;

    public RacingCarGame(final MoveStrategy moveStrategy) {
        this.moveDeterminer = new MoveDeterminer(moveStrategy);
    }

    public boolean registerCar(final String rawCarNames) {
        racingCars = new RacingCars(rawCarNames, moveDeterminer);
        return true;
    }

    public boolean registerRound(final String round) {
        this.round = new Round(round);
        return true;
    }

    public GameResult startGame() {
        checkRegistration();
        RoundResults roundResults = new RoundResults();
        for (Integer integer : round) {
            roundResults.addRoundResult(racingCars.playOneRound());
        }
        return new GameResult(roundResults, racingCars.calculateWinners());
    }

    private void checkRegistration() {
        if (racingCars == null) {
            throw new InvalidRegistrationException("자동차 이름을 입력해주세요.");
        }
        if (round == null) {
            throw new InvalidRegistrationException("라운드를 입력해주세요.");
        }
    }
}
