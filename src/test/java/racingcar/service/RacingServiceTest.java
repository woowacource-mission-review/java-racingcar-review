package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.RaceResult;
import racingcar.service.dto.CarDto;

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
        assertThat(cars.shouldMove(x -> true)).isNotEmpty();
    }

    @Test
    @DisplayName("경주 후 우승자 구하기")
    void startRaceTest1() {
        List<CarDto> expected = List.of(new CarDto("pobi", 3), new CarDto("crong", 3));
        int repeatNumber = 3;

        RaceResult raceResult = racingService.startRace(repeatNumber, cars);

        assertThat(raceResult.getWinners()).isEqualTo(expected);
    }

    @Test
    @DisplayName("경주 후 상태 확인")
    void startRaceTest2() {
        // given
        List<CarDto> expected1 = List.of(new CarDto("pobi", 1), new CarDto("crong", 1));
        List<CarDto> expected2 = List.of(new CarDto("pobi", 2), new CarDto("crong", 2));

        // when
        RaceResult raceResult = racingService.startRace(2, cars);

        // then
        assertThat(raceResult.next()).isEqualTo(expected1);
        assertThat(raceResult.next()).isEqualTo(expected2);
        assertThat(raceResult.hasNext()).isFalse();
    }
}