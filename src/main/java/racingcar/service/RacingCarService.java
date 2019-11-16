package racingcar.service;

import org.apache.commons.lang3.math.NumberUtils;
import racingcar.domain.*;
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

    public Cars createCarsByParsingWith(final String names) {
        List<String> carNames = parseCarNames(names);

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private List<String> parseCarNames(final String names) {
        String[] nameTokens = names.split(CAR_NAME_DELIMITER);
        if (nameTokens.length < MIN_NUM_OF_RACING_CARS) {
            throw new LackOfCarsException();
        }

        List<String> carNames = trim(nameTokens);
        if (hasDuplicateNamesIn(carNames)) {
            throw new DuplicateCarsException();
        }
        return carNames;
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

    public GameRound createGameRound(final String count) {
        if (NumberUtils.isNumber(count)) {
            return new GameRound(Integer.parseInt(count));
        }
        throw new NumberFormatException("정수로 입력해 주세요.");
    }

    public RacingGameResult race(final Cars cars, final GameRound gameRound) {
        MovingStrategy movingStrategy = new RandomMovingStrategy();

        RacingGameHistory history = new RacingGameHistory();
        for (int round = 0; round < gameRound.getRoundNum(); round++) {
            cars.move(movingStrategy);
//            history.record(new GameRound(round), cars.clone());
        }
        return new RacingGameResult(history);
    }
}
