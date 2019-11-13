package racingcar.controller;

import racingcar.exception.LackOfCarsException;
import racingcar.view.InputView;

public class RacingCarController {

    public void run() {
        String carNames = InputView.inputCarName();

        String[] nameTokens = carNames.split(",");
        if (nameTokens.length < 2) {
            throw new LackOfCarsException("자동차의 수는 " + 2 + "대 이상 입력해 주세요.");
        }
    }
}
