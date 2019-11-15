package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DefaultRandomMoveStrategyTest {
    private DefaultRandomMoveStrategy moveStrategy = new DefaultRandomMoveStrategy();

    @Test
    @DisplayName("4 이상 입력시 이동 가능")
    void over_4_movable() {
        assertThat(moveStrategy.canMove(4)).isTrue();
    }

    @Test
    @DisplayName("4 미만 입력시 이동 불가능")
    void under_4_cant_movable() {
        assertThat(moveStrategy.canMove(3)).isFalse();
    }

    @Test
    @DisplayName("0 미만 입력시 에러")
    void under_0_error() {
        assertThrows(IllegalArgumentException.class, () -> moveStrategy.canMove(-1));
    }

    @Test
    @DisplayName("10 이상 입력시 에러")
    void over_10_error() {
        assertThrows(IllegalArgumentException.class, () -> moveStrategy.canMove(10));
    }
}
