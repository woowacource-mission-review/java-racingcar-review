package racingcar.domain.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.car.Position.DEFAULT_POSITION;

class PositionTest {

    @Test
    void 포지션_증가() {
        Position position = Position.newInstance();
        Position increasedPosition = position.increase();
        int actual = increasedPosition.getPosition();

        assertThat(actual).isEqualTo(DEFAULT_POSITION + 1);
    }

    @Test
    void 캐싱_확인_테스트() {
        Position position1 = Position.newInstance();
        Position position2 = Position.newInstance();

        assertThat(position1 == position2).isTrue();
    }
}