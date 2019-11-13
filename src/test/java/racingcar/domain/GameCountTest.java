package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.LackOfGameCountException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameCountTest {

    @Test
    @DisplayName("게임 시도 횟수 생성하기")
    void createGameCount() {
        GameCount gameCount = new GameCount(3L);

        assertThat(gameCount.getCount()).isEqualTo(3L);
    }

    @Test
    void equals() {
        GameCount gameCount = new GameCount(3L);

        assertThat(gameCount.equals(new GameCount(3L))).isTrue();
    }

    @Test
    @DisplayName("1 미만의 게임 횟수가 들어올 경우 예외 처리")
    void illegalGameCount() {
        assertThrows(LackOfGameCountException.class, () -> new GameCount(0L));
    }
}