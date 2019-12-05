package racingcar.console;

import racingcar.console.view.InputView;
import racingcar.console.view.OutputView;
import racingcar.domain.car.Cars;
import racingcar.domain.movestrategy.MoveStrategy;
import racingcar.domain.movestrategy.RandomNumberMoveStrategy;
import racingcar.domain.race.RaceResult;
import racingcar.service.RacingService;

public class App {
    public static void main(String[] args) {
        final MoveStrategy moveStrategy = new RandomNumberMoveStrategy();
        final RacingService racingService = new RacingService(moveStrategy);

        final Cars cars = createCars(racingService);
        final RaceResult raceResult = startRace(racingService, cars);

        OutputView.printRaceResult(raceResult);
        OutputView.printWinner(raceResult.getWinners());
    }

    private static Cars createCars(final RacingService racingService) {
        try {
            final String names = InputView.inputNames();
            return racingService.createCars(names);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return createCars(racingService);
        }
    }

    private static RaceResult startRace(final RacingService racingService, final Cars cars) {
        try {
            final int repeatNumber = InputView.inputRepeatNumber();
            return racingService.startRace(repeatNumber, cars);
        } catch (RuntimeException e) {
            OutputView.printException(e.getMessage());
            return startRace(racingService, cars);
        }
    }
}
