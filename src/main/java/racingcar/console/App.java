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

        final String names = InputView.inputNames();
        final Cars cars = racingService.createCars(names);

        final int repeatNumber = InputView.inputRepeatNumber();
        final RaceResult raceResult = racingService.startRace(repeatNumber, cars);

        OutputView.printRaceResult(raceResult);
        OutputView.printWinner(raceResult.getWinners());
    }
}
