package model;

import model.exception.CarCreateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @Test
    @DisplayName("차 생성")
    void car_create() {
        assertDoesNotThrow(() -> new Car("ABC"));
    }

    @Test
    @DisplayName("빈 문자열 입력시 차 생성 에러")
    void car_create_empty_string() {
        assertThrows(CarCreateException.class, () -> new Car(""));
    }

    @Test
    @DisplayName("NULL 입력시 차 생성 에러")
    void car_create_null() {
        assertThrows(CarCreateException.class, () -> new Car(null));
    }
}
