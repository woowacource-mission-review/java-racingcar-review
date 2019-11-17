package com.woowacourse.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars("aaa,bbb,ccc");
    }

    @Test
    void moveCars() {
        cars.moveCars(()->true);
        assertEquals(cars.getPositionOf(0),1);
        assertEquals(cars.getPositionOf(1),1);
        assertEquals(cars.getPositionOf(2),1);
    }
}