package model;

import model.exception.CarCreateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static model.Car.DEFAULT_POSITION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    private static final String CAR_NAME = "ABC";

    @Test
    @DisplayName("차 생성")
    void car_create() {
        assertDoesNotThrow(() -> new Car(CAR_NAME));
    }

    @Test
    @DisplayName("기본 위치가 0인지 비교")
    void default_position_compare() {
        Car car = new Car(CAR_NAME);
        assertThat(car.matchPosition(DEFAULT_POSITION)).isTrue();
    }

    @Test
    @DisplayName("포지션 입력 차 생성")
    void car_create_with_position() {
        assertDoesNotThrow(() -> new Car(CAR_NAME, 2));
    }

    @Test
    @DisplayName("특정 위치로 생성할 경우 위치 비교")
    void specific_position_compare() {
        int position = 2;
        Car car = new Car(CAR_NAME, position);
        assertThat(car.matchPosition(position)).isTrue();
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
}
