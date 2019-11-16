package model;

import model.exception.InvalidRoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoundTest {
    @Test
    @DisplayName("1 이상의 정수 입력시 라운드 생성")
    void over_1_create() {
        assertDoesNotThrow(() -> new Round(1));
    }

    @Test
    @DisplayName("1 미만의 정수 입력시 에러")
    void under_1_error() {
        assertThrows(InvalidRoundException.class, () -> new Round(0));
    }
}
