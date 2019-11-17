package racingcar.domain.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RepeatNumberTest {

    @Test
    void 음수_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> RepeatNumber.from(-1));
    }

    @Test
    void 숫자_0_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> RepeatNumber.from(0));
    }

    @Test
    void 숫자_67_정상입력() {
        assertDoesNotThrow(() -> RepeatNumber.from(67));
    }

    @Test
    void 문자로_숫자_입력_변환_처리() {
        assertDoesNotThrow(() -> RepeatNumber.from("67"));
    }
}