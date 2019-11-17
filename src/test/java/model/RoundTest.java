package model;

import model.exception.InvalidRoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static model.Round.MIN_ROUND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoundTest {
    @Test
    @DisplayName("1 이상의 정수 입력시 라운드 생성")
    void over_1_create() {
        assertDoesNotThrow(() -> new Round(MIN_ROUND));
    }

    @Test
    @DisplayName("1 미만의 정수 입력시 에러")
    void under_1_error() {
        assertThrows(InvalidRoundException.class, () -> new Round(MIN_ROUND - 1));
    }

    @Test
    @DisplayName("Iterable 반복 수 테스트")
    void iterable() {
        int roundCount = 5;
        Round round = new Round(roundCount);

        int iter = 0;
        for (Integer i : round) {
            ++iter;
        }
        assertThat(iter).isEqualTo(roundCount);
    }
}
