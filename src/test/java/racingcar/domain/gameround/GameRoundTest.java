package racingcar.domain.gameround;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.LackOfGameCountException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameRoundTest {

    @Test
    @DisplayName("게임 시도 횟수 생성하기")
    void createGameCount() {
        GameRound gameRound = GameRoundPool.of(3L);

        assertThat(gameRound.getRoundNum()).isEqualTo(3L);
    }

    @Test
    @DisplayName("1 미만의 게임 횟수가 들어올 경우 예외 처리")
    void illegalGameCount() {
        assertThrows(LackOfGameCountException.class, () -> GameRoundPool.of(0L));
    }
}