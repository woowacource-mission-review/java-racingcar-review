package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.race.RaceResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingServiceTest {
    private RacingService racingService;
    private Cars cars;

    @BeforeEach
    void setUp() {
        racingService = new RacingService(x -> true);
        cars = racingService.createCars("pobi,crong");
    }

    @Test
    void createCarsTest() {
        assertThat(cars.tryMove(x -> true)).isNotEmpty();
    }

    @Test
    @DisplayName("경주 후 우승자 구하기")
    void startRaceTest1() {
        List<Car> expected = List.of(Car.of("pobi", 3), Car.of("crong", 3));
        int repeatNumber = 3;

        RaceResult raceResult = racingService.startRace(repeatNumber, cars);

        assertThat(raceResult.getWinners()).isEqualTo(expected);
    }

    @Test
    @DisplayName("경주 후 상태 확인")
    void startRaceTest2() {
        // given
        List<Car> expected1 = List.of(Car.of("pobi", 1), Car.of("crong", 1));
        List<Car> expected2 = List.of(Car.of("pobi", 2), Car.of("crong", 2));

        // when
        RaceResult raceResult = racingService.startRace(2, cars);

        // then
        assertThat(raceResult.next()).isEqualTo(expected1);
        assertThat(raceResult.next()).isEqualTo(expected2);
        assertThat(raceResult.hasNext()).isFalse();
    }
}