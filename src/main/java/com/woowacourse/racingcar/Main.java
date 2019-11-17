package com.woowacourse.racingcar;

import com.woowacourse.racingcar.domain.RacingGame;
import com.woowacourse.racingcar.domain.converter.CarsConverter;
import com.woowacourse.racingcar.domain.converter.GameNumberConverter;
import com.woowacourse.racingcar.view.InputMessage;
import com.woowacourse.racingcar.view.InputView;

public class Main {

    public static void main(String[] args) {
        String carNames = InputView.inputStr(InputMessage.INPUT_NAME);
        int tryNumber = InputView.inputNumber(InputMessage.INPUT_TRY_NUMBER);

        RacingGame racingGame = new RacingGame(CarsConverter.toCars(carNames),
            GameNumberConverter.toGameNumber(tryNumber));


    }
}
