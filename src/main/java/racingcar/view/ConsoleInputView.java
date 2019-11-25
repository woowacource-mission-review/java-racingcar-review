package racingcar.view;

import java.util.Scanner;

public class ConsoleInputView implements InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public String inputCarName() {
        return inputWithMessage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
    }

    @Override
    public String inputGameRound() {
        return inputWithMessage("시도할 회수는 몇회인가요?");
    }

    private String inputWithMessage(String message) {
        System.out.println(message);
        return SCANNER.nextLine();
    }
}
