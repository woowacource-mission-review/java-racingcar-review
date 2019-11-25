package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;

public class RacingCarGame {

    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController(new ConsoleInputView(), new ConsoleOutputView());
        racingCarController.run();
    }
}
