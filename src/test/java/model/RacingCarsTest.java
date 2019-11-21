package model;

import model.exception.InvalidRegistrationException;
import model.result.MoveResult;
import model.result.RoundResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
        assertThrows(NullPointerException.class,
                () -> new RacingCars(null, trueDeterminer));
    }

    @Test
    @DisplayName("생성자에 빈 리스트 입력")
    void register_empty_list() {
        assertThrows(InvalidRegistrationException.class,
                () -> new RacingCars(Collections.emptyList(), trueDeterminer));
    }

    @Test
    @DisplayName("생성자에 1개의 자동차 리스트 입력")
    void register_singleton_list() {
        assertThrows(InvalidRegistrationException.class,
                () -> new RacingCars(Collections.singletonList(new Car("ABC")), trueDeterminer));
    }

    @Test
    @DisplayName("생성자에 중복된 자동차 이름 리스트 입력")
    void register_duplicated_name_list() {
        assertThrows(InvalidRegistrationException.class,
                () -> new RacingCars(Arrays.asList(new Car("ABC"), new Car("ABC")), trueDeterminer));
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

    @Test
    @DisplayName("RoundResult 확인")
    void check_round_results() {
        RacingCars racingCars = new RacingCars(cars, trueDeterminer);
        RoundResult roundResult = racingCars.moveCars();
        assertTrue(roundResult.contains(new MoveResult("ABC", 1)));
        assertTrue(roundResult.contains(new MoveResult("DEF", 1)));
    }

    @Test
    @DisplayName("우승자 혼자일 때 확인")
    void calculate_only_winner() {
        Car winner = new Car("ABC", 2);
        Car loser = new Car("DEF");
        cars = Arrays.asList(winner, loser);
        RacingCars racingCars = new RacingCars(cars, trueDeterminer);
        racingCars.moveCars();
        assertTrue(racingCars.calculateWinners().contains(winner));
        assertFalse(racingCars.calculateWinners().contains(loser));
    }

    @Test
    @DisplayName("우승자 여러명일 때 확인")
    void calculate_multiple_winners() {
        Car winner1 = new Car("ABC", 2);
        Car winner2 = new Car("DEF", 2);
        cars = Arrays.asList(winner1, winner2);
        RacingCars racingCars = new RacingCars(cars, trueDeterminer);
        racingCars.moveCars();
        assertTrue(racingCars.calculateWinners().contains(winner1));
        assertTrue(racingCars.calculateWinners().contains(winner2));
    }
}
