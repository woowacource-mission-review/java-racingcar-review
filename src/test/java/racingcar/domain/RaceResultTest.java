package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.service.dto.CarDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceResultTest {

    private CarDto first1 = new CarDto("first", 2);
    private CarDto second1 = new CarDto("second", 1);
    private List<CarDto> cars1 = List.of(first1, second1);

    private CarDto first2 = new CarDto("first", 3);
    private CarDto second2 = new CarDto("second", 2);
    private List<CarDto> cars2 = List.of(first2, second2);

    private List<RaceStatus> raceStatuses = List.of(new RaceStatus(cars1), new RaceStatus(cars2));

    private RaceResult raceResult = new RaceResult(raceStatuses);

    @Test
    void getWinnersTest() {
        List<CarDto> expected = List.of(this.first2);

        List<CarDto> winners = raceResult.getWinners();

        assertThat(winners).isEqualTo(expected);
    }
}