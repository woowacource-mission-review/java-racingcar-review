package racingcar.domain;

import java.util.List;

public class Cars {

    List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public int size() {
        return cars.size();
    }
}
