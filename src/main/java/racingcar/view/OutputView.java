package racingcar.view;

import org.apache.commons.lang3.StringUtils;
import racingcar.domain.GameRound;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGameResult;
import racingcar.utils.TimeUtils;

public class OutputView {

    private static final String ERROR_MESSAGE_PREFIX = "ERROR : ";
    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final int DISPLAY_INTERVAL_TIME = 500;
    private static final String CAR_POSITION_DELIMITER = " : ";
    private static final String CAR_POSITION_DISPLAY_SIGN = "-";

    private OutputView() {
    }

    public static void printExceptionMessageForPlayer(final IllegalArgumentException e) {
        System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
    }

    public static void show(final RacingGameResult result) {
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
        for (int carIndex = 0; carIndex < cars.size(); carIndex++) {
            RacingCar car = cars.get(carIndex);
            System.out.println(car.getAlignedName() + CAR_POSITION_DELIMITER + generatePositionLine(car));
        }
    }

    private static String generatePositionLine(RacingCar car) {
        return StringUtils.repeat(CAR_POSITION_DISPLAY_SIGN, Math.toIntExact(car.getPosition()));
    }
}
