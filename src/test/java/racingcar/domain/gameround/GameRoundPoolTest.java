package racingcar.domain.gameround;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameRoundPoolTest {

    @Test
    @DisplayName("GameRoundPool 캐시 테스트")
    void of() {
        GameRound gameRound = GameRoundPool.of(1);

        assertThat(gameRound == GameRoundPool.of(1)).isTrue();
    }
}