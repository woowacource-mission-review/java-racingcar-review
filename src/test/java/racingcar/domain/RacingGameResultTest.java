package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.RacingCar;
import racingcar.domain.car.RacingCars;
import racingcar.domain.gameround.GameRoundPool;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameResultTest {

    private RacingGameResult result;

    @BeforeEach
    void setUp() {
        RacingGameHistory history = new RacingGameHistory();

        List<RacingCar> carList = Arrays.asList(new RacingCar("red", 1), new RacingCar("blue", 1), new RacingCar("green", 0));
        RacingCars cars = new RacingCars(carList);

        List<RacingCar> carList2 = Arrays.asList(new RacingCar("red", 2), new RacingCar("blue", 1), new RacingCar("green", 0));
        RacingCars cars2 = new RacingCars(carList2);

        history.record(GameRoundPool.of(1L), cars);
        history.record(GameRoundPool.of(2L), cars2);

        result = new RacingGameResult(history);
    }

    @Test
    void findWinners() {
        RacingCars winners = result.findWinners();

        assertThat(winners).isNotNull();
        assertThat(winners.contains(new RacingCar("red"))).isTrue();
        assertThat(winners.contains(new RacingCar("blue"))).isFalse();
        assertThat(winners.contains(new RacingCar("green"))).isFalse();
    }
}