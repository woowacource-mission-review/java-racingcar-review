package com.woowacourse.racingcar.view;

import com.woowacourse.racingcar.domain.Car;
import com.woowacourse.racingcar.domain.Cars;
import com.woowacourse.racingcar.domain.GameResult;

import java.util.List;

public class OutputView {

    private static final String CAR_DELIMITER = " : ";
    private static final String CAR_POSITION_BAR = "-";
    public static final String WINNER_DELIMITER = ", ";

    public static void printResult(final GameResult gameResult) {
        System.out.println("실행 결과");
        for (int round = 0; round < gameResult.getSize(); round++) {
            printCars(gameResult.get(round));
            System.out.println();
        }
        printWinner(gameResult.getWinners());
    }

    private static void printCars(final Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            printCar(cars.get(i));
        }
    }

    private static void printCar(final Car car) {
        System.out.print(car.getName() + CAR_DELIMITER);
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(CAR_POSITION_BAR);
        }
        System.out.println();
    }

    private static void printWinner(final List<Car> winners) {
        for (Car winner : winners) {
            System.out.print(winner.getName() + WINNER_DELIMITER);
        }
        System.out.println("가 최종 우승했습니다.");
    }
}
