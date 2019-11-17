package support;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarNameUtils {
    private final static String DELIMITER = ",";

    public static List<String> parse(String inputNames) {
        List<String> carNames = Stream.of(inputNames.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());

        if (isDuplicated(carNames)) {
            throw new DuplicatedCarNameException();
        }

        return carNames;
    }

    private static boolean isDuplicated(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);

        return names.size() != uniqueNames.size();
    }
}
