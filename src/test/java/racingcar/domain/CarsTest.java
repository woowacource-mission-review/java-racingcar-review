package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private List<Car> carList;

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();

        carList.add(new Car("red", 0));
        carList.add(new Car("blue", 1));
        carList.add(new Car("green", 1));
    }

    @Test
    void size() {
        Cars cars = new Cars(carList);

        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void contains() {
        Cars cars = new Cars(carList);

        assertThat(cars.contains(new Car("red"))).isTrue();
        assertThat(cars.contains(new Car("blue"))).isTrue();
        assertThat(cars.contains(new Car("green"))).isTrue();

        assertThat(cars.contains(new Car("black"))).isFalse();
    }

    @Test
    void move() {
        Cars cars = new Cars(carList);
        cars.move(() -> true);

        assertThat(cars.get(0).getPosition()).isEqualTo(1L);
        assertThat(cars.get(1).getPosition()).isEqualTo(2L);
        assertThat(cars.get(2).getPosition()).isEqualTo(2L);
    }
}