package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private static final String DELIMITER = ",";

    private final List<Car> cars;

    public Cars(final String names) {
        this.cars = createCars(names);
    }

    private List<Car> createCars(final String names) {
        return Stream.of(names.split(DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
