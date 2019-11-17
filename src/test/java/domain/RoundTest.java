package domain;

import domain.exception.InvalidRoundNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoundTest {

    @Test
    @DisplayName("1 이상의 정상적인 시도 횟수를 생성한다.")
    void create_valid_round() {
        assertDoesNotThrow(() -> new Round("1"));
    }

    @Test
    @DisplayName("1 미만의 비정상적인 시도 횟수를 생성하면 오류가 발생한다.")
    void create_invalid_round() {
        assertThrows(InvalidRoundNumberException.class, () -> new Round("0"));
    }

    @Test
    @DisplayName("숫자가 아닌 시도 횟수를 생성하면 오류가 발생한다.")
    void create_not_number() {
        assertThrows(InvalidRoundNumberException.class, () -> new Round("abc"));
    }
}
