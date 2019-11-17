package com.woowacourse.racingcar;

import com.woowacourse.racingcar.domain.GameResult;
import com.woowacourse.racingcar.domain.RacingGame;
import com.woowacourse.racingcar.domain.moveStrategy.MoveRandomStrategy;
import com.woowacourse.racingcar.view.InputMessage;
import com.woowacourse.racingcar.view.InputView;
import com.woowacourse.racingcar.view.OutputView;

public class Main {

    public static void main(String[] args) {
        String carsName = InputView.inputStr(InputMessage.INPUT_NAME);
        int tryNumber = InputView.inputNumber(InputMessage.INPUT_TRY_NUMBER);

        RacingGame racingGame = new RacingGame(carsName, tryNumber);
        GameResult gameResult = racingGame.play(new MoveRandomStrategy());

        OutputView.printResult(gameResult);
    }
}
