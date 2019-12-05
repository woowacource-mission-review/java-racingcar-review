package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car = Car.of("베디");

    @Test
    void 논리적_동치성_테스트() {
        int position = 2;
        String name = "베디";

        assertThat(Car.of(name, 2)).isEqualTo(Car.of(name, position));
    }

    @Test
    @DisplayName("이동 안함")
    void tryMoveTest1() {
        // given
        int expected = car.getPosition();

        // when
        int actual = car.tryMove(x -> false).getPosition();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("이동")
    void tryMoveTest2() {
        // given
        int expected = car.getPosition() + Position.UNIT_INCREASE;

        // when
        int actual = car.tryMove(x -> true).getPosition();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("이동하지 않아도 새로운 인스턴스 생성하는지 확인")
    void tryMoveTest3() {
        Car expected = Car.of("베디");
        Car actual = expected.tryMove((x)->false);

        assertThat(actual).isEqualTo(expected);
        assertThat(actual == expected).isFalse();
    }

    @Test
    void matchPositionTest() {
        int position = 1;
        Car car = Car.of("bedi", position);

        assertThat(car.matchPosition(position)).isTrue();
    }
}