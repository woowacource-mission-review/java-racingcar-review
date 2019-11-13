package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();

        cars.add(new Car("red"));
        cars.add(new Car("blue"));
        cars.add(new Car("green"));
    }

    @Test
    void size() {
        Cars cars = new Cars(this.cars);

        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void contains() {
        Cars cars = new Cars(this.cars);

        assertThat(cars.contains(new Car("red"))).isTrue();
        assertThat(cars.contains(new Car("blue"))).isTrue();
        assertThat(cars.contains(new Car("green"))).isTrue();

        assertThat(cars.contains(new Car("black"))).isFalse();
    }
}