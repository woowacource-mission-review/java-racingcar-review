package com.woowacourse.racingcar.domain.validator;

import com.google.common.collect.Sets;
import com.woowacourse.racingcar.domain.exception.DuplicateCarNameException;
import com.woowacourse.racingcar.domain.exception.InvalidCarsSizeException;

public class CarsNameValidator {

    private static final int MIN_CAR_SIZE = 2;
    private static final String CAR_NAME_DELIMITER = ",";

    public static boolean check(final String carNamesWithComma) {
        String[] cars = carNamesWithComma.split(CAR_NAME_DELIMITER);
        if (hasDuplicatedName(cars)) {
            throw new DuplicateCarNameException();
        }
        if (isValidSize(cars)) {
            throw new InvalidCarsSizeException();
        }
        return true;
    }

    private static boolean hasDuplicatedName(final String[] cars) {
        return cars.length != Sets.newHashSet(cars).size();
    }

    private static boolean isValidSize(final String[] cars) {
        return cars.length < MIN_CAR_SIZE;
    }
}
