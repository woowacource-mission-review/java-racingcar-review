import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElseThrow(CarsEmptyException::new)
                ;
    }

    public List<Car> getCarsOnMaxPosition() {
        return cars.stream()
                .filter(car -> car.getPosition().equals(this.getMaxPosition()))
                .collect(Collectors.toList())
                ;
    }
}
