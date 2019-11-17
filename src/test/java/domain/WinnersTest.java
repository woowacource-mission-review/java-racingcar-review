package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class WinnersTest {
    private static final CarName name1 = new CarName("car1");
    private static final CarName name2 = new CarName("car2");
    private static final CarName name3 = new CarName("car3");

    private static final Car car1 = new Car(name1);
    private static final Car car2 = new Car(name2);
    private static final Car car3 = new Car(name3);

    private Winner winner1;
    private Winner winner2;
    private Winner winner3;

    @BeforeEach
    void setUp() {
        winner1 = new Winner(car1);
        winner2 = new Winner(car2);
        winner3 = new Winner(car3);
    }

    @Test
    @DisplayName("최종 우숭자들을 가지고 있는 객체를 생성한다.")
    void select_winner() {
        assertDoesNotThrow(() -> new Winners(Arrays.asList(winner1, winner2, winner3)));
    }
}
