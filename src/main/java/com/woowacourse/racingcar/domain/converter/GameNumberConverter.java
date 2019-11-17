package com.woowacourse.racingcar.domain.converter;

import com.woowacourse.racingcar.domain.GameNumber;
import com.woowacourse.racingcar.domain.validator.GameNumberValidator;

public class GameNumberConverter {

    public static GameNumber toGameNumber(final int gameNumber) {
        GameNumberValidator.check(gameNumber);
        return new GameNumber(gameNumber);
    }
}
