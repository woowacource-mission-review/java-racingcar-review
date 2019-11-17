package com.woowacourse.racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CarTest {

    @Test
    void initCar() {
        String carName = "abc";
        assertDoesNotThrow(() -> new Car(carName));
    }
}
