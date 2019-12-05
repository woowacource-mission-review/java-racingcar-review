package racingcar.console.view;

import java.util.Scanner;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        return scanner.nextLine();
    }

    public static int inputRepeatNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("숫자만 입력 가능합니다.");
            return inputRepeatNumber();
        }
    }
}
