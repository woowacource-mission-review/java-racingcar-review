package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @DisplayName("레이싱 카에 이름을 붙일 수 있다.")
    @Test
    void racingCarNamingTest() {
        RacingCar car = new RacingCar("moomin");
        assertThat(car.getName()).isEqualTo("moomin");
    }

    @DisplayName("레이싱 카는 전진할 수 있다.")
    @Test
    void racingCarGoForwardTest() {
        RacingCar car = new RacingCar("moomin");
        car.goForward(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("레이싱 카는 멈출 수 있다.")
    @Test
    void racingCarStopTest() {
        RacingCar car = new RacingCar("moomin");
        car.goForward(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
