package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    private List<RacingCar> carList;

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();

        carList.add(new RacingCar("red", 0));
        carList.add(new RacingCar("blue", 1));
        carList.add(new RacingCar("green", 1));
    }

    @Test
    void size() {
        RacingCars cars = new RacingCars(carList);

        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void contains() {
        RacingCars cars = new RacingCars(carList);

        assertThat(cars.contains(new RacingCar("red"))).isTrue();
        assertThat(cars.contains(new RacingCar("blue"))).isTrue();
        assertThat(cars.contains(new RacingCar("green"))).isTrue();

        assertThat(cars.contains(new RacingCar("black"))).isFalse();
    }

    @Test
    void move() {
        RacingCars cars = new RacingCars(carList);
        cars.move(() -> true);

        assertThat(cars.get(0).getPosition()).isEqualTo(1L);
        assertThat(cars.get(1).getPosition()).isEqualTo(2L);
        assertThat(cars.get(2).getPosition()).isEqualTo(2L);
    }
}