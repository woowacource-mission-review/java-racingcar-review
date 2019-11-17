package controller;

import domain.Cars;
import domain.Round;
import domain.exception.CarNameLengthExcessException;
import domain.exception.InvalidRoundNumberException;
import domain.factory.CarsFactory;
import support.CarNameUtils;
import support.DuplicatedCarNameException;

import java.util.List;
import java.util.Scanner;

public class ConsoleInputController {
    private Scanner scanner = new Scanner(System.in);

    public Cars getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputNames = scanner.nextLine();

        try {
            List<String> carNames = CarNameUtils.parse(inputNames);
            return CarsFactory.create(carNames);
        } catch (DuplicatedCarNameException | CarNameLengthExcessException e) {
            System.out.println(e.getMessage());
            return getCars();
        }
    }

    public Round getRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputRound = scanner.nextLine();

        try {
            return new Round(inputRound);
        } catch (InvalidRoundNumberException e) {
            System.out.println(e.getMessage());
            return getRound();
        }
    }
}
