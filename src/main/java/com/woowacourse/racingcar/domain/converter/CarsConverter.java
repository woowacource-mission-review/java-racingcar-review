package com.woowacourse.racingcar.domain.converter;

import com.woowacourse.racingcar.domain.Car;
import com.woowacourse.racingcar.domain.Cars;
import com.woowacourse.racingcar.domain.validator.CarsNameValidator;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CarsConverter {

    private static final String CARS_NAME_DELIMITER = ",";

    public static Cars toCars(String carNameWithComma) {
        CarsNameValidator.check(carNameWithComma);

        String[] carsName = carNameWithComma.split(CARS_NAME_DELIMITER);
        List<Car> cars = Arrays.stream(carsName).map(String::trim)
            .map(Car::new)
            .collect(toList());

        return new Cars(cars);
    }
}
