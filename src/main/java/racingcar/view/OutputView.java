package racingcar.view;

import org.apache.commons.lang3.StringUtils;
import racingcar.domain.GameRound;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGameResult;
import racingcar.utils.TimeUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String ERROR_MESSAGE_PREFIX = "ERROR : ";
    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final int DISPLAY_INTERVAL_TIME = 500;
    private static final String CAR_POSITION_DELIMITER = " : ";
    private static final String CAR_POSITION_DISPLAY_SIGN = "-";
    private static final String GAME_WINNER_MESSAGE = "이(가) 최종 우승했습니다.";
    private static final String WINNER_NAME_DELIMITER = ", ";

    private OutputView() {
    }

    public static void showExceptionMessageForPlayer(final IllegalArgumentException e) {
        System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
    }

    public static void showGameProcess(final RacingGameResult result) {
        System.out.println();
        System.out.println(GAME_RESULT_MESSAGE);

        for (int round = GameRound.MIN_NUM_OF_GAME_ROUND; round <= result.getNumOfGameRounds(); round++) {
            RacingCars cars = result.read(round);
            showResultOfOneRound(cars);
            System.out.println();

            TimeUtils.sleep(DISPLAY_INTERVAL_TIME);
        }
    }

    private static void showResultOfOneRound(final RacingCars cars) {
        cars.stream()
                .forEach(OutputView::showResultOfCar);
    }

    private static void showResultOfCar(final RacingCar car) {
        System.out.println(car.getAlignedName() + CAR_POSITION_DELIMITER + generatePositionLine(car));
    }

    private static String generatePositionLine(RacingCar car) {
        return StringUtils.repeat(CAR_POSITION_DISPLAY_SIGN, Math.toIntExact(car.getPosition()));
    }

    public static void showWinners(final RacingGameResult result) {
        RacingCars winners = result.findWinners();
        System.out.println(generateWinnersName(winners) + GAME_WINNER_MESSAGE);
    }

    private static String generateWinnersName(RacingCars cars) {
        List<String> carNames = cars.stream()
                .map(RacingCar::getName)
                .collect(Collectors.toList());

        return StringUtils.join(carNames, WINNER_NAME_DELIMITER);
    }
}
