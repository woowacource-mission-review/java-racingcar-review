package racingcar.domain;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public Car get(int index) {
        return cars.get(index);
    }

    public int size() {
        return cars.size();
    }

    public boolean contains(final Car car) {
        return cars.contains(car);
    }

    public void move(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
    }
}
