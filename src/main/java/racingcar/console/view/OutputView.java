package racingcar.console.view;

import racingcar.domain.car.Car;
import racingcar.domain.race.RaceResult;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String ROUTE = "-";

    private OutputView() {
    }

    public static void printRaceResult(final RaceResult raceResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("실행 결과\n");
        while (raceResult.hasNext()) {
            printCurrentRace(raceResult.next(), sb);
        }
        System.out.println(sb.toString());
    }

    private static void printCurrentRace(final List<Car> cars, final StringBuilder sb) {
        cars.forEach(car -> printCar(sb, car));
        sb.append("\n");
    }

    private static void printCar(final StringBuilder sb, final Car car) {
        sb.append(String.format("%s : ", car.getName()));
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append(ROUTE);
        }
        sb.append("\n");
    }


    public static void printWinner(final List<Car> winners) {
        final String joinedWinners = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(String.format("%s가 최종 우승했습니다.", joinedWinners));
    }

    public static void printException(final String message) {
        System.err.println(message);
    }
}
