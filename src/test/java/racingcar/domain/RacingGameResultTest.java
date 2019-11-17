package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

        GameRound gameRound = new GameRound(1L);
        history.record(gameRound, cars);

        result = new RacingGameResult(history);
    }

    @Test
    void findWinners() {
        RacingCars winners = result.findWinners();

        assertThat(winners).isNotNull();
    }
}