package com.woowacourse.racingcar.domain.converter;

import com.woowacourse.racingcar.domain.Car;
import com.woowacourse.racingcar.domain.Cars;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsConverterTest {

    @Test
    void toCars() {
        String carNamesWithComma = "aaa,bbb,ccc";
        List<Car> cars = Arrays.asList(new Car("aaa"), new Car("bbb"), new Car("ccc"));

        assertEquals(CarsConverter.toCars(carNamesWithComma), new Cars(cars));
    }
}