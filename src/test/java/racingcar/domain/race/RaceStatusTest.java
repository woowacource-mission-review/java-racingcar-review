package racingcar.domain.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.exception.RaceStatusEmptyException;
import racingcar.service.dto.CarDto;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    @DisplayName("carDtos 가 비어있는 경우 예외처리")
    void RaceStatusEmptyException() {
        assertThrows(RaceStatusEmptyException.class, () -> RaceStatus.from(Collections.emptyList()));
    }
}