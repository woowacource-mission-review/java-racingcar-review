package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ExcessOfCarNameLengthException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {

    @Test
    @DisplayName("Car 생성 테스트")
    void createCar() {
        String carName = "red";
        Car car = new Car(carName);

        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    @DisplayName("생성 직후 Car의 position은 0이다")
    void initPosition() {
        Car car = new Car("red");

        assertThat(car.getPosition()).isEqualTo(0L);
    }

    @Test
    @DisplayName("자동차 이름의 길이는 최대 5자")
    void lengthOfCarName() {
        assertDoesNotThrow(() -> new Car("green"));

        assertThrows(ExcessOfCarNameLengthException.class, () -> new Car("violet"));
    }
}
