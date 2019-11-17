package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {

    @Test
    @DisplayName(",가 아닌 다른 delimiter를 사용한 경우")
    void createTest() {
        assertThrows(IllegalArgumentException.class, () -> new Cars("pobi:crong.honux"));
    }

    @Test
    void 이름_입력_2명_미만_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new Cars("pobi"));

    }

    @Test
    void 전체_이동_테스트() {
        // given
        Cars cars = new Cars("pobi,crong,honux");
        int movedPosition = Position.DEFAULT_POSITION + 1;
        List<Integer> expectedPosition = List.of(movedPosition, movedPosition, movedPosition);

        // when
        cars.shouldMove(x -> true);
        List<Integer> actualPositions = cars.getCars().stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        // then
        assertThat(actualPositions).isEqualTo(expectedPosition);
    }

    @Test
    void 우승자_구하기() {
        // given
        Cars cars = new Cars("pobi,crong,honux");
        cars.shouldMove(car -> car.getName().equals("pobi"));
        cars.shouldMove(car -> car.getName().equals("crong"));

        // when
        List<String> winners = cars.getWinners();

        // then
        assertThat(winners).isEqualTo(List.of("pobi", "crong"));
    }
}