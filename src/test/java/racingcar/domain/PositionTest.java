package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.Position.DEFAULT_POSITION;

class PositionTest {

    @Test
    void 포지션_증가() {
        Position position = Position.newInstance();
        Position increasedPosition = position.increase();
        int actual = increasedPosition.getPosition();

        assertThat(actual).isEqualTo(DEFAULT_POSITION + 1);
    }
}