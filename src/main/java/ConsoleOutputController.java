import java.util.stream.Collectors;

public class ConsoleOutputController {

    public void drawOneStep(Cars cars) {
        for (Car car : cars.getCars()) {
            drawCurrentCar(car);
        }
        System.out.println();
    }

    private void drawCurrentCar(Car car) {
        System.out.print(car.getName() + " : ");
        for (Integer i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void drawWinners(Winners winners) {
        String gameResult = winners.getWinners().stream()
                .map(Winner::getWinnerName)
                .collect(Collectors.joining(", "))
                ;

        System.out.println("[" + gameResult + "]" + "가(이) 최종 우승했습니다.");
    }
}
