import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersFactoryTest {
    private static final CarName name1 = new CarName("car1");
    private static final CarName name2 = new CarName("car2");
    private static final CarName name3 = new CarName("car3");
    private static final CarName name4 = new CarName("car4");

    @Test
    @DisplayName("Car3의 위치는 1, 나머지가 0일 때, 정상적으로 우승자를 만드는지 검사한다.")
    void create_one_winner() {
        Car car1 = new Car(name1);
        Car car2 = new Car(name2);
        Car car3 = new Car(name3);
        Car car4 = new Car(name4);

        car1.move(new ForwardMoveStrategy());
        Cars cars = new Cars(Arrays.asList(car1, car2, car3, car4));

        Winner winner1 = new Winner(car1);

        Winners winners = WinnersFactory.create(cars);
        assertThat(winners.getWinners()).contains(winner1);
        assertThat(winners.getWinners().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Car1, Car2의 위치는 2, Car3의 위치는 1, Car4의 위치는 0일 때, 정상적으로 우승자를 만드는지 검사한다.")
    void create_two_winners() {
        Car car1 = new Car(name1);
        Car car2 = new Car(name2);
        Car car3 = new Car(name3);
        Car car4 = new Car(name4);

        car1.move(new ForwardMoveStrategy());
        car1.move(new ForwardMoveStrategy());
        car2.move(new ForwardMoveStrategy());
        car2.move(new ForwardMoveStrategy());
        car3.move(new ForwardMoveStrategy());
        Cars cars = new Cars(Arrays.asList(car1, car2, car3, car4));

        Winner winner1 = new Winner(car1);
        Winner winner2 = new Winner(car2);

        Winners winners = WinnersFactory.create(cars);
        assertThat(winners.getWinners()).contains(winner1, winner2);
        assertThat(winners.getWinners().size()).isEqualTo(2);
    }
}
