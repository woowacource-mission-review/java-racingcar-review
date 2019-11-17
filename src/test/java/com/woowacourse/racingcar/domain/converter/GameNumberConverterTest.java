package com.woowacourse.racingcar.domain.converter;

import com.woowacourse.racingcar.domain.GameNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameNumberConverterTest {

    @Test
    void make_game_number() {
        assertEquals(GameNumberConverter.toGameNumber(5), new GameNumber(5));
    }
}