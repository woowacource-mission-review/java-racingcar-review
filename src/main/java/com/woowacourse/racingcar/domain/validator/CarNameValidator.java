package com.woowacourse.racingcar.domain.validator;

import com.woowacourse.racingcar.domain.exception.BlankCarNameException;
import com.woowacourse.racingcar.domain.exception.InvalidCarNameException;
import org.apache.commons.lang3.StringUtils;

public class CarNameValidator {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static boolean check(String carName) {
        if (isBlank(carName)) {
            throw new BlankCarNameException();
        }
        if (isInvalidLength(carName)) {
            throw new InvalidCarNameException();
        }

        return true;
    }

    private static boolean isBlank(String carName) {
        return StringUtils.isBlank(carName);
    }

    private static boolean isInvalidLength(String carName) {
        return carName.length() > MAX_CAR_NAME_LENGTH;
    }
}
