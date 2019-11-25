package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingGameResult;
import racingcar.domain.car.RacingCar;
import racingcar.domain.car.RacingCars;
import racingcar.domain.gameround.GameRound;
import racingcar.domain.gameround.GameRoundPool;

import java.util.Arrays;

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
        RacingCars cars = new RacingCars(Arrays.asList(new RacingCar("red"), new RacingCar("blue")));
        RacingGameResult result = racingCarService.race(cars, GameRoundPool.of(1), () -> true);

        assertThat(result).isNotNull();
    }
}