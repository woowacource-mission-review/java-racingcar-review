package domain;

import domain.exception.CarNameLengthExcessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameTest {

    @Test
    @DisplayName("자동차 이름을 정상적으로 생성한다.")
    void create_name() {
        assertDoesNotThrow(() -> new CarName("comac"));
    }

    @Test
    @DisplayName("자동자 이름으로 5글자를 초과한 문자열을 입력했을 때 오류가 발생한다.")
    void create_name_length_error() {
        assertThrows(CarNameLengthExcessException.class, () -> new CarName("codemcd"));
    }
}
