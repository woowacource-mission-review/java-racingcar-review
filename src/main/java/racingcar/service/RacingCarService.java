package racingcar.service;

import org.apache.commons.lang3.math.NumberUtils;
import racingcar.domain.RacingGameHistory;
import racingcar.domain.RacingGameResult;
import racingcar.domain.car.RacingCar;
import racingcar.domain.car.RacingCars;
import racingcar.domain.gameround.GameRound;
import racingcar.domain.gameround.GameRoundPool;
import racingcar.domain.movingstrategy.MovingStrategy;
import racingcar.exception.DuplicateCarsException;
import racingcar.exception.LackOfCarsException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingCarService {

    private static final String CAR_NAME_DELIMITER = ",";
    public static final int MIN_NUM_OF_RACING_CARS = 2;
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "정수로 입력해 주세요.";

    public RacingCars createCarsByParsingWith(final String names) {
        List<String> carNames = parseCarNames(names);

        List<RacingCar> cars = carNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
        return new RacingCars(cars);
    }

    private List<String> parseCarNames(final String names) {
        String[] nameTokens = names.split(CAR_NAME_DELIMITER);
        if (isNotEnoughCars(nameTokens)) {
            throw new LackOfCarsException();
        }

        List<String> carNames = trim(nameTokens);
        if (hasDuplicateNamesIn(carNames)) {
            throw new DuplicateCarsException();
        }
        return carNames;
    }

    private boolean isNotEnoughCars(final String[] nameTokens) {
        return nameTokens.length < MIN_NUM_OF_RACING_CARS;
    }

    private List<String> trim(final String[] nameTokens) {
        return Arrays.stream(nameTokens)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private boolean hasDuplicateNamesIn(final List<String> names) {
        Set<String> nameSet = new HashSet<>(names);

        return names.size() != nameSet.size();
    }

    public GameRound createGameRound(final String round) {
        if (NumberUtils.isNumber(round)) {
            return GameRoundPool.of(Integer.parseInt(round));
        }
        throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
    }

    public RacingGameResult race(final RacingCars cars, final GameRound gameRound, final MovingStrategy movingStrategy) {
        RacingGameHistory history = new RacingGameHistory();
        for (long round = GameRound.MIN_NUM_OF_GAME_ROUND; round <= gameRound.getRoundNum(); round++) {
            cars.move(movingStrategy);
            history.record(GameRoundPool.of(round), new RacingCars(cars));
        }
        return new RacingGameResult(history);
    }
}
