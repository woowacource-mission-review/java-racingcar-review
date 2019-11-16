package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameHistoryTest {

    private RacingGameHistory history;

    @BeforeEach
    void setUp() {
        history = new RacingGameHistory();
    }

    @Test
    void record_and_read() {
        List<RacingCar> carList = Arrays.asList(new RacingCar("red", 1), new RacingCar("blue", 1), new RacingCar("green", 0));
        RacingCars cars = new RacingCars(carList);

        GameRound gameRound = new GameRound(1L);
        history.record(gameRound, cars);

        assertThat(history.read(gameRound)).isEqualTo(cars);
    }
}