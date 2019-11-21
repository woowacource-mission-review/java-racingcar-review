package view;

import java.util.Scanner;

import static model.RacingCarGame.CAR_NAME_DELIMITER;
import static model.Round.MIN_ROUND;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 (" + CAR_NAME_DELIMITER + ")를 기준으로 구분).");
        return scanner.nextLine();
    }

    public int inputRound() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(MIN_ROUND + "이상의 정수를 입력해주세요.");
            return inputRound();
        }
    }
}
