import controller.ConsoleInputController;
import controller.ConsoleOutputController;
import domain.Cars;
import domain.Round;
import domain.Winners;
import domain.factory.WinnersFactory;
import domain.strategy.RandomMoveStrategy;

public class racingGame {
    public static void main(String[] args) {
        ConsoleInputController inputController = new ConsoleInputController();
        ConsoleOutputController outputController = new ConsoleOutputController();

        Cars cars = inputController.getCars();
        Round round = inputController.getRound();
        for (Integer i = 0; i < round.getNumber(); i++) {
            cars.moveAll(new RandomMoveStrategy());
            outputController.drawOneStep(cars);
        }

        Winners winners = WinnersFactory.create(cars);
        outputController.drawWinners(winners);
    }
}
