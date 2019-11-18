package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car = Car.of("베디");


    @Test
    @DisplayName("이동 안함")
    void shouldMoveTest1() {
        // given
        int expected = car.getPosition();

        // when
        car.shouldMove(x -> false);
        int actual = car.getPosition();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("이동")
    void shouldMoveTest2() {
        // given
        int expected = car.getPosition() + Position.UNIT_INCREASE;

        // when
        car.shouldMove(x -> true);
        int actual = car.getPosition();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}