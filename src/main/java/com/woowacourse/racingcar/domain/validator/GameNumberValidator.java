package com.woowacourse.racingcar.domain.validator;

import com.woowacourse.racingcar.domain.exception.InvalidGameNumberException;

public class GameNumberValidator {

    public static boolean check(int tryNumber) {
        if (isInvalidGameNumber(tryNumber)) {
            throw new InvalidGameNumberException();
        }
        return true;
    }

    private static boolean isInvalidGameNumber(final int tryNumber) {
        return tryNumber < 1 || tryNumber > 10;
    }
}
