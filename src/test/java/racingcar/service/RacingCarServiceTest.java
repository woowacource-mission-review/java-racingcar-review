package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.GameRound;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.exception.DuplicateCarsException;
import racingcar.exception.LackOfCarsException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingCarServiceTest {

    private RacingCarService racingCarService;

    @BeforeEach
    void setUp() {
        racingCarService = new RacingCarService();
    }

    @Test
    @DisplayName("콤마로 구분된 Car 이름들을 받아 Cars로 반환하는 메소드")
    void createCarsByParsingWith() {
        RacingCars cars = racingCarService.createCarsByParsingWith("red, blue, green");

        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.contains(new RacingCar("red"))).isTrue();
        assertThat(cars.contains(new RacingCar("blue"))).isTrue();
        assertThat(cars.contains(new RacingCar("green"))).isTrue();
    }

    @Test
    @DisplayName("콤마로 구분된 Car 이름의 개수가 2개 미만일 경우 예외 발생")
    void createCarsByParsingWith_lackOfCarsException() {
        assertThrows(LackOfCarsException.class, () -> racingCarService.createCarsByParsingWith("red"));
    }

    @Test
    @DisplayName("Car 이름이 중복된 경우 예외 발생")
    void createCarsByParsingWith_duplicateCars() {
        assertThrows(DuplicateCarsException.class, () -> racingCarService.createCarsByParsingWith("red, blue, red"));
    }

    @Test
    @DisplayName("시도 횟수를 입력 받는 메소드")
    void createGameCount() {
        GameRound gameRound = racingCarService.createGameRound("3");

        assertThat(gameRound.getRoundNum()).isEqualTo(3L);
    }

    @Test
    @DisplayName("정수 입력이 아닌 시도 횟수일 경우 예외 발생")
    void createGameCount_NumberFormatException() {
        assertThrows(NumberFormatException.class, () -> racingCarService.createGameRound("a"));
    }

    @Test
    void race() {
        // TODO: 16/11/2019 create test
    }
}