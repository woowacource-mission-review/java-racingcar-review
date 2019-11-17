package racing.view;

import racing.model.RacingCar;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutputView {
    public static void printRace(List<RacingCar> cars) {
        cars.forEach(car -> System.out.println(String.format("%s : %s", car.getName(), getDashes(car))));
    }

    public static void printWinners(List<RacingCar> winners) {
        String winnersNames = winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));
        System.out.println(String.format("%s가 최종 우승했습니다.", winnersNames));
    }

    private static String getDashes(RacingCar car) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            builder.append("-");
        }
        return builder.toString();
    }
}
