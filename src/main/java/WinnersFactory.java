import java.util.List;
import java.util.stream.Collectors;

public class WinnersFactory {
    public static Winners create(Cars cars) {
        List<Winner> winners = cars.getCarsOnMaxPosition().stream()
                .map(Winner::new)
                .collect(Collectors.toList())
                ;

        return new Winners(winners);
    }
}
