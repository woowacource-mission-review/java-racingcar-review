package domain;

import domain.factory.CarsFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {
    private static final String NAME1 = "car1";
    private static final String NAME2 = "car2";
    private static final String NAME3 = "car3";

    @Test
    @DisplayName("car1, car2, car3 객체를 갖는 domain.Cars 객체를 생성한다.")
    void create() {
        List<String> carNames = Arrays.asList(NAME1, NAME2, NAME3);
        Cars cars = CarsFactory.create(carNames);

        assertThat(cars.getCars().size()).isEqualTo(3);
    }
}
