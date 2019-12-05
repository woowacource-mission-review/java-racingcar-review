package racingcar.domain.race;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceResultTest {

    private Car first1 = Car.of("first", 2);
    private Car second1 = Car.of("secon", 1);
    private List<Car> cars1 = List.of(first1, second1);

    private Car first2 = Car.of("first", 3);
    private Car second2 = Car.of("secon", 2);
    private List<Car> cars2 = List.of(first2, second2);

    private List<RaceStatus> raceStatuses = List.of(new RaceStatus(cars1), new RaceStatus(cars2));

    private RaceResult raceResult = new RaceResult(raceStatuses);

    @Test
    void getWinnersTest() {
        List<Car> expected = List.of(this.first2);

        List<Car> winners = raceResult.getWinners();

        assertThat(winners).isEqualTo(expected);
    }

    @Test
    void IteratorTest() {
        assertThat(raceResult.next()).isEqualTo(cars1);
        assertThat(raceResult.next()).isEqualTo(cars2);
        assertThat(raceResult.hasNext()).isFalse();
    }
}