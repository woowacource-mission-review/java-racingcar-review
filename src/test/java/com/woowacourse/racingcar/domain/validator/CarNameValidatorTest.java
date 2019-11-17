package com.woowacourse.racingcar.domain.validator;

import com.woowacourse.racingcar.domain.exception.BlankCarNameException;
import com.woowacourse.racingcar.domain.exception.InvalidCarNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarNameValidatorTest {

    @Test
    @DisplayName("올바른 이름")
    void check_car_name() {
        String name = "aaa";
        assertTrue(CarNameValidator.isValid(name));
    }

    @Test
    @DisplayName("공백 이름 검사")
    void check_car_name_with_blank() {
        String name = "";
        assertThrows(BlankCarNameException.class,() -> CarNameValidator.isValid(name));
    }

    @Test
    @DisplayName("이름 5글자 넘는 경우 검사")
    void check_car_name_length() {
        String name="conasCONASconas";
        assertThrows(InvalidCarNameException.class, () -> CarNameValidator.isValid(name));
    }
}
