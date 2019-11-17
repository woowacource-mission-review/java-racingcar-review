package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.dto.CarDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceStatusTest {

    @Test
    @DisplayName("현재 선두 자동차 구하기")
    void getWinnersTest() {
        // given
        CarDto first = new CarDto("first", 2);
        CarDto second = new CarDto("second", 1);
        List<CarDto> cars = List.of(first, second);
        RaceStatus raceStatus = RaceStatus.from(cars);

        // when
        List<CarDto> winners = raceStatus.getCurrentWinners();

        // then
        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getName()).isEqualTo("first");
    }
}