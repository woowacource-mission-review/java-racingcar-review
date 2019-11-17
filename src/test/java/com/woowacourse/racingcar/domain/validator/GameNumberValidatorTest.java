package com.woowacourse.racingcar.domain.validator;

import com.woowacourse.racingcar.domain.exception.InvalidGameNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameNumberValidatorTest {

    @Test
    void check_valid_game_number() {
        assertTrue(GameNumberValidator.check(5));
    }

    @Test
    void check_invalid_game_number() {
        assertThrows(InvalidGameNumberException.class, () -> GameNumberValidator.check(1000));
    }
}