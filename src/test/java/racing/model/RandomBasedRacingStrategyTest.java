package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomBasedRacingStrategyTest {
    @DisplayName("난수가 4 이상일 경우 전진")
    @Test
    void goTest() {
        RandomBasedRacingStrategy strategy = new RandomBasedRacingStrategy(() -> 4, 4);
        assertThat(strategy.isGo()).isTrue();
    }

    @DisplayName("난수가 4 미만일 경우 멈춤")
    @Test
    void stopTest() {
        RandomBasedRacingStrategy strategy = new RandomBasedRacingStrategy(() -> 3, 4);
        assertThat(strategy.isGo()).isFalse();
    }
}