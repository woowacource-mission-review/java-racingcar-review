package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.RacingCar;
import racingcar.domain.car.RacingCars;

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
        RacingCar redCar = new RacingCar("red", 1);
        RacingCar blueCar = new RacingCar("blue", 1);

        List<RacingCar> carList = Arrays.asList(redCar, blueCar);
        RacingCars cars = new RacingCars(carList);

        GameRound gameRound = new GameRound(1L);
        history.record(gameRound, cars);

        RacingCars readCars = history.read(gameRound);
        RacingCar readRedCar = readCars.get(0);
        RacingCar readBlueCar = readCars.get(1);

        assertThat(readRedCar.equals(redCar)).isTrue();
        assertThat(readRedCar.isSamePosition(redCar)).isTrue();
        assertThat(readBlueCar.equals(blueCar)).isTrue();
        assertThat(readBlueCar.isSamePosition(blueCar)).isTrue();
    }

    @Test
    void getNumOfGameRounds() {
        assertThat(history.getNumOfGameRounds()).isEqualTo(0L);

        List<RacingCar> carList = Arrays.asList(new RacingCar("red", 1), new RacingCar("blue", 1), new RacingCar("green", 0));
        RacingCars cars = new RacingCars(carList);

        GameRound gameRound = new GameRound(1L);
        history.record(gameRound, cars);

        assertThat(history.getNumOfGameRounds()).isEqualTo(1L);
    }
}