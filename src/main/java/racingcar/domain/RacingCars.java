package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private List<RacingCar> cars;

    public RacingCars(final List<RacingCar> cars) {
        this.cars = cars;
    }

    public RacingCar get(int index) {
        return cars.get(index);
    }

    public int size() {
        return cars.size();
    }

    public boolean contains(final RacingCar car) {
        return cars.contains(car);
    }

    public void move(MovingStrategy movingStrategy) {
        for (RacingCar car : cars) {
            car.move(movingStrategy);
        }
    }
}
