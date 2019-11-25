package racingcar.service;

import org.apache.commons.lang3.math.NumberUtils;
import racingcar.domain.RacingGameHistory;
import racingcar.domain.RacingGameResult;
import racingcar.domain.car.RacingCar;
import racingcar.domain.car.RacingCars;
import racingcar.domain.gameround.GameRound;
import racingcar.domain.gameround.GameRoundPool;
import racingcar.domain.movingstrategy.MovingStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarService {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "정수로 입력해 주세요.";

    public RacingCars createCarsByParsingWith(final String names) {
        List<RacingCar> cars = parseCarNames(names);

        return new RacingCars(cars);
    }

    private List<RacingCar> parseCarNames(final String names) {
        String[] nameTokens = names.split(CAR_NAME_DELIMITER);

        return Arrays.stream(nameTokens)
                .map(String::trim)
                .map(RacingCar::new)
                .collect(Collectors.toList());
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
            history.record(GameRoundPool.of(round), RacingCars.of(cars));
        }
        return new RacingGameResult(history);
    }
}
