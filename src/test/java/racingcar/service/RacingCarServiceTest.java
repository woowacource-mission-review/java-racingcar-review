package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.GameCount;
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
        Cars cars = racingCarService.createCarsByParsingWith("red, blue, green");

        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.contains(new Car("red"))).isTrue();
        assertThat(cars.contains(new Car("blue"))).isTrue();
        assertThat(cars.contains(new Car("green"))).isTrue();
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
        GameCount gameCount = racingCarService.createGameCount("3");

        assertThat(gameCount.getCount()).isEqualTo(3L);
    }

    @Test
    @DisplayName("정수 입력이 아닌 시도 횟수일 경우 예외 발생")
    void createGameCount_NumberFormatException() {
        assertThrows(NumberFormatException.class, () -> racingCarService.createGameCount("a"));
    }
}