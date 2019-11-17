package racing;

import racing.controller.RacingGame;
import racing.model.RacingCarProceedStrategy;
import racing.model.RandomBasedRacingStrategy;
import racing.model.RandomIntegerGenerator;
import racing.model.ResultStatistics;
import racing.view.ConsoleInputView;
import racing.view.ConsoleOutputView;

import java.util.List;

public class RacingApp {
    public static void main(String[] args) {
        List<String> carNames = ConsoleInputView.inputCarNames();
        int numOfRaces = ConsoleInputView.inputNumOfRaces();
        RacingCarProceedStrategy strategy = new RandomBasedRacingStrategy(new RandomIntegerGenerator(0, 9), 4);
        RacingGame racingGame = new RacingGame(carNames, strategy);

        System.out.println("\n실행결과");
        for (int i = 0; i < numOfRaces; i++) {
            racingGame.proceed();
            ConsoleOutputView.printRace(racingGame.getCars());
        }

        ResultStatistics resultStatistics = new ResultStatistics(racingGame.getCars());
        ConsoleOutputView.printWinners(resultStatistics.findWinners());
    }
}
