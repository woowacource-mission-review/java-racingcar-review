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
}
