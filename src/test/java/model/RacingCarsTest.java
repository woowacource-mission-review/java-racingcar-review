package model;

import model.exception.CarCreateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarsTest {
    @Test
    @DisplayName("생성자 정상 동작 확인")
    void register_normal() {
        List<Car> cars = Arrays.asList(new Car("ABC"), new Car("DEF"));
        assertDoesNotThrow(() -> new RacingCars(cars));
    }

    @Test
    @DisplayName("생성자 파라미터에 NULL 입력")
    void register_null() {
        assertThrows(CarCreateException.class,
                () -> new RacingCars(null));
    }

    @Test
    @DisplayName("생성자에 빈 리스트 입력")
    void register_empty_list() {
        assertThrows(CarCreateException.class,
                () -> new RacingCars(Collections.emptyList()));
    }
}
