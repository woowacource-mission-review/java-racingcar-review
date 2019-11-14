package model;

import model.exception.CarCreateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static model.Car.DEFAULT_POSITION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("자동차 이동 성공시 위치 증가")
    void car_move_success() {
        Car car = new Car(CAR_NAME);
        assertEquals(car.move(true), DEFAULT_POSITION + 1);
    }

    @Test
    @DisplayName("자동차 이동 실패시 위치 동일한지")
    void car_move_failure() {
        Car car = new Car(CAR_NAME);
        assertEquals(car.move(false), DEFAULT_POSITION);
    }
}
