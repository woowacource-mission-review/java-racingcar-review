package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ExcessOfCarNameLengthException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingCarNameTest {

    @Test
    @DisplayName("자동차 이름의 길이는 최대 5자")
    void lengthOfCarName() {
        assertDoesNotThrow(() -> new RacingCar("green"));

        assertThrows(ExcessOfCarNameLengthException.class, () -> new RacingCar("violet"));
    }

    @Test
    @DisplayName("공백으로 글자수가 채워진 이름 리턴")
    void getAlignedName() {
        RacingCarName redCarName = new RacingCarName("red");
        RacingCarName blueCarName = new RacingCarName("blue");
        RacingCarName greenCarName = new RacingCarName("green");

        assertThat(redCarName.getAlignedName()).isEqualTo("red  ");
        assertThat(blueCarName.getAlignedName()).isEqualTo("blue ");
        assertThat(greenCarName.getAlignedName()).isEqualTo("green");
    }

    @Test
    void equals() {
        RacingCarName redCarName = new RacingCarName("red");

        assertThat(redCarName).isEqualTo(new RacingCarName("red"));
    }
}