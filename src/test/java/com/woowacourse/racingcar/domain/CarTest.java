package com.woowacourse.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("conas");
    }

    @Test
    void initCar() {
        String carName = "abc";
        assertDoesNotThrow(() -> new Car(carName));
    }

    @Test
    void can_move() {
        car.move(() -> true);
        assertEquals(car.getPosition(), 1);
    }

    @Test
    void can_not_move() {
        car.move(() -> false);
        assertEquals(car.getPosition(), 0);
    }
}
