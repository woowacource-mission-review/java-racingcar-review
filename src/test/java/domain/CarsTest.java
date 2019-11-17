package domain;

import domain.exception.CarsEmptyException;
import domain.strategy.ForwardMoveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsTest {
    private static final CarName name1 = new CarName("car1");
    private static final CarName name2 = new CarName("car2");
    private static final CarName name3 = new CarName("car3");

    @Test
    @DisplayName("자동차들 중 가장 멀리간 위치를 반환한다.")
    void get_max_position() {
        Car car1 = new Car(name1);
        Car car2 = new Car(name2);
        Car car3 = new Car(name3);

        car2.move(new ForwardMoveStrategy());
        car3.move(new ForwardMoveStrategy());
        car3.move(new ForwardMoveStrategy());
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        assertThat(cars.getMaxPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("가장 멀리 간 자동차 리스트를 가져온다.")
    void get_cars_on_max_position() {
        Car car1 = new Car(name1);
        Car car2 = new Car(name2);
        Car car3 = new Car(name3);

        car2.move(new ForwardMoveStrategy());
        car2.move(new ForwardMoveStrategy());
        car3.move(new ForwardMoveStrategy());
        car3.move(new ForwardMoveStrategy());
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        assertThat(cars.getCarsOnMaxPosition()).contains(car2, car3);
        assertThat(cars.getCarsOnMaxPosition().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("비어있는 리스트로 생성된 Cars에서 getMasPosition()을 호출했을 때 예외를 던진다.")
    void if_cars_empty_then_throw_exception() {
        Cars emptyCars = new Cars(Collections.emptyList());
        assertThrows(CarsEmptyException.class, emptyCars::getMaxPosition);
    }
}
