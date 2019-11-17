package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ExcessOfCarNameLengthException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingCarTest {

    @Test
    @DisplayName("Car 생성 테스트")
    void createCar() {
        String carName = "red";
        RacingCar car = new RacingCar(carName);

        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    @DisplayName("생성 직후 Car의 position은 0이다")
    void initPosition() {
        RacingCar car = new RacingCar("red");

        assertThat(car.getPosition()).isEqualTo(0L);
    }

    @Test
    @DisplayName("자동차 이름의 길이는 최대 5자")
    void lengthOfCarName() {
        assertDoesNotThrow(() -> new RacingCar("green"));

        assertThrows(ExcessOfCarNameLengthException.class, () -> new RacingCar("violet"));
    }

    @Test
    @DisplayName("position 상관 없이 자동차 이름이 같으면 같은 자동차")
    void equals() {
        RacingCar car1 = new RacingCar("red", 0);
        RacingCar car2 = new RacingCar("red", 1);

        assertThat(car1.equals(car2)).isTrue();
    }

    @Test
    void move() {
        RacingCar car1 = new RacingCar("red", 0);
        RacingCar car2 = new RacingCar("red", 0);
        car1.move(() -> true);
        car2.move(() -> false);

        assertThat(car1.getPosition()).isEqualTo(1L);
        assertThat(car2.getPosition()).isEqualTo(0L);
    }

    @Test
    @DisplayName("새로운 생성자로 생성할 경우 깊은 복사가 되는지 테스트")
    void deepCopyConstructor() {
        RacingCar car = new RacingCar("red", 1);
        RacingCar copiedCar = new RacingCar(car);

        car.move(() -> true);

        assertThat(copiedCar.getPosition()).isEqualTo(1L);
    }

    @Test
    @DisplayName("공백으로 글자수가 채워진 이름 리턴")
    void getAlignedName() {
        RacingCar redCar = new RacingCar("red");
        RacingCar blueCar = new RacingCar("blue");
        RacingCar greenCar = new RacingCar("green");

        assertThat(redCar.getAlignedName()).isEqualTo("red  ");
        assertThat(blueCar.getAlignedName()).isEqualTo("blue ");
        assertThat(greenCar.getAlignedName()).isEqualTo("green");
    }

    @Test
    void compareTo() {
        RacingCar redCar = new RacingCar("red", 1);
        RacingCar blueCar = new RacingCar("blue", 2);
        RacingCar greenCar = new RacingCar("green", 1);

        assertThat(redCar).isLessThan(blueCar);
        assertThat(blueCar).isGreaterThan(redCar);
        assertThat(redCar).isEqualByComparingTo(greenCar);
    }

    @Test
    void isSamePosition() {
        RacingCar redCar = new RacingCar("red", 1);
        RacingCar blueCar = new RacingCar("blue", 1);
        RacingCar greenCar = new RacingCar("green", 2);

        assertThat(redCar.isSamePosition(blueCar)).isTrue();
        assertThat(redCar.isSamePosition(greenCar)).isFalse();
    }
}
