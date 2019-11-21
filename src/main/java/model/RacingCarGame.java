package model;

import model.exception.InvalidRegistrationException;
import model.result.GameResult;
import model.result.RoundResults;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    public static final String CAR_NAME_DELIMITER = ",";

    private final MoveDeterminer moveDeterminer;
    private RacingCars racingCars;
    private Round round;

    public RacingCarGame(final MoveDeterminer moveDeterminer) {
        this.moveDeterminer = moveDeterminer;
    }

    public boolean registerCar(final String rawCarNames) {
        racingCars = new RacingCars(convertRawCarNamesToCars(rawCarNames), moveDeterminer);
        return true;
    }

    private List<Car> convertRawCarNamesToCars(final String rawCarNames) {
        return Arrays.stream(rawCarNames.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public boolean registerRound(final int round) {
        this.round = new Round(round);
        return true;
    }

    public GameResult startGame() {
        checkRegistration();
        RoundResults roundResults = new RoundResults();
        for (Integer integer : round) {
            roundResults.addRoundResult(racingCars.moveCars());
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
