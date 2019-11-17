package model;

import model.exception.CarCreateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarsTest {
    private MoveDeterminer trueDeterminer = new MoveDeterminer(new AlwaysTrueMoveStrategy());
    private MoveDeterminer falseDeterminer = new MoveDeterminer(new AlwaysFalseMoveStrategy());

    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = Arrays.asList(new Car("ABC"), new Car("DEF"));
    }

    @Test
    @DisplayName("생성자 정상 동작 확인")
    void register_normal() {
        assertDoesNotThrow(() -> new RacingCars(cars, trueDeterminer));
    }

    @Test
    @DisplayName("생성자 파라미터에 NULL 입력")
    void register_null() {
        assertThrows(CarCreateException.class,
                () -> new RacingCars(null, trueDeterminer));
    }

    @Test
    @DisplayName("생성자에 빈 리스트 입력")
    void register_empty_list() {
        assertThrows(CarCreateException.class,
                () -> new RacingCars(Collections.emptyList(), trueDeterminer));
    }

    @Test
    @DisplayName("MoveDeterminer가 true를 리턴할 때 움직이는지")
    void if_determiner_return_true_move() {
        RacingCars racingCars = new RacingCars(cars, trueDeterminer);
        racingCars.moveCars();
        for (Car car : cars) {
            assertThat(car.matchPosition(1)).isTrue();
        }
    }

    @Test
    @DisplayName("MoveDeterminer가 false를 리턴할 때 움직이지 않는지")
    void if_determiner_return_false_not_move() {
        RacingCars racingCars = new RacingCars(cars, falseDeterminer);
        racingCars.moveCars();
        for (Car car : cars) {
            assertThat(car.matchPosition(0)).isTrue();
        }
    }
}
