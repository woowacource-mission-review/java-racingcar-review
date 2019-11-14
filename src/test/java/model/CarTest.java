package model;

import model.exception.CarCreateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @Test
    @DisplayName("차 생성")
    void car_create() {
        assertDoesNotThrow(() -> new Car("ABC"));
    }

    @Test
    @DisplayName("기본 위치가 0인지 비교")
    void default_position_compare() {
        Car car = new Car("ABC");
        assertThat(car.matchPosition(0)).isTrue();
    }

    @Test
    @DisplayName("포지션 입력 차 생성")
    void car_create_with_position() {
        assertDoesNotThrow(() -> new Car("ABC", 2));
    }

    @Test
    @DisplayName("특정 위치로 생성할 경우 위치 비교")
    void specific_position_compare() {
        Car car = new Car("ABC", 2);
        assertThat(car.matchPosition(2)).isTrue();
    }

    @Test
    @DisplayName("이름에 빈 문자열 입력시 차 생성 에러")
    void car_create_empty_string_name() {
        assertThrows(CarCreateException.class, () -> new Car(""));
    }

    @Test
    @DisplayName("이름에 NULL 입력시 차 생성 에러")
    void car_create_null_name() {
        assertThrows(CarCreateException.class, () -> new Car(null));
    }

    @Test
    @DisplayName("위치에 NULL 입력시 차 생성 에러")
    void car_create_null_position() {
        assertThrows(CarCreateException.class, () -> new Car("ABC", null));
    }
}
