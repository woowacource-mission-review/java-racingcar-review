package view;

import view.exception.RepeatCountExceedException;

import java.util.Scanner;

import static model.RacingCarGame.CAR_NAME_DELIMITER;

public class InputView {
    private static final int MAX_REPEAT_COUNT = 5;

    private Scanner scanner = new Scanner(System.in);

    public String inputCarNames(final int repeatCount) {
        checkRepeatCount(repeatCount);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 (" + CAR_NAME_DELIMITER + ")를 기준으로 구분).");
        return scanner.nextLine();
    }

    public String inputRound(final int repeatCount) {
        checkRepeatCount(repeatCount);
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextLine();
    }

    private void checkRepeatCount(final int repeatCount) {
        if (repeatCount > MAX_REPEAT_COUNT) {
            throw new RepeatCountExceedException();
        }
    }
}
