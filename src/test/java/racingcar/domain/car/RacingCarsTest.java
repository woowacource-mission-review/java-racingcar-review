package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.DuplicateCarsException;
import racingcar.exception.LackOfCarsException;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingCarsTest {

    private RacingCars cars;

    @BeforeEach
    void setUp() {
        List<RacingCar> carList = new ArrayList<>();

        carList.add(new RacingCar("red", 0));
        carList.add(new RacingCar("blue", 1));
        carList.add(new RacingCar("green", 1));

        cars = new RacingCars(carList);
    }

    @Test
    void size() {
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void contains() {
        assertThat(cars.contains(new RacingCar("red"))).isTrue();
        assertThat(cars.contains(new RacingCar("blue"))).isTrue();
        assertThat(cars.contains(new RacingCar("green"))).isTrue();

        assertThat(cars.contains(new RacingCar("black"))).isFalse();
    }

    @Test
    @DisplayName("콤마로 구분된 Car 이름의 개수가 2개 미만일 경우 예외 발생")
    void createCarsByParsingWith_lackOfCarsException() {
        List<RacingCar> carList = new ArrayList<>();

        carList.add(new RacingCar("red", 0));

        assertThrows(LackOfCarsException.class, () -> new RacingCars(carList));
    }

    @Test
    @DisplayName("Car 이름이 중복된 경우 예외 발생")
    void createCarsByParsingWith_duplicateCars() {
        List<RacingCar> carList = new ArrayList<>();

        carList.add(new RacingCar("red", 0));
        carList.add(new RacingCar("blue", 1));
        carList.add(new RacingCar("red", 1));

        assertThrows(DuplicateCarsException.class, () -> new RacingCars(carList));
    }

    @Test
    void move() {
        cars.move(() -> true);

        assertThat(cars.get(0).getPosition()).isEqualTo(1L);
        assertThat(cars.get(1).getPosition()).isEqualTo(2L);
        assertThat(cars.get(2).getPosition()).isEqualTo(2L);
    }

    @Test
    @DisplayName("새로운 생성자로 생성할 경우 깊은 복사가 되는지 테스트")
    void deepCopyConstructor() {
        RacingCars copiedCars = RacingCars.of(cars);
        cars.move(() -> true);

        assertThat(copiedCars.get(0).getPosition()).isEqualTo(0L);
        assertThat(copiedCars.get(1).getPosition()).isEqualTo(1L);
        assertThat(copiedCars.get(2).getPosition()).isEqualTo(1L);
    }

    @Test
    @DisplayName("해당 Round의 우승자를 찾는 로직 테스트")
    void findWinners() {
        List<RacingCar> winners = cars.findWinners();

        assertThat(winners.contains(new RacingCar("red"))).isFalse();
        assertThat(winners.contains(new RacingCar("blue"))).isTrue();
        assertThat(winners.contains(new RacingCar("green"))).isTrue();
    }
}