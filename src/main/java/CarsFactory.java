import java.util.List;
import java.util.stream.Collectors;

public class CarsFactory {

    public static Cars create(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(name -> new Car(new CarName(name)))
                .collect(Collectors.toList())
                ;

        return new Cars(cars);
    }
}
