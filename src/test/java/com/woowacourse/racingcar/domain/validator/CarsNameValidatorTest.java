package com.woowacourse.racingcar.domain.validator;

import com.woowacourse.racingcar.domain.exception.DuplicateCarNameException;
import com.woowacourse.racingcar.domain.exception.InvalidCarsSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsNameValidatorTest {

    @Test
    @DisplayName("올바른 자동차 이름 입력")
    void checkNames() {
        String carNames = "aaa,bbb,ccc";
        assertDoesNotThrow(() -> CarNamesValidator.isValid(carNames));
    }

    @Test
    @DisplayName("중복된 이름 검사")
    void checkNames_name_over_flow() {
        String carNames = "aaa,aaa";
        assertThrows(DuplicateCarNameException.class, () -> CarNamesValidator.isValid(carNames));
    }

    @Test
    @DisplayName("자동차 수 2대 이상이 아닌 경우")
    void checkNames_invalid_size() {
        String carNames = "aaa";
        assertThrows(InvalidCarsSizeException.class, () -> CarNamesValidator.isValid(carNames));
    }
}
