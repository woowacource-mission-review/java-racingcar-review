package racing.view;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Scanner;

public class ConsoleInputView {
    public static final Scanner SC = new Scanner(System.in);

    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        return Lists.newArrayList(SC.nextLine().split(","));
    }

    public static int inputNumOfRaces() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(SC.nextLine());
    }
}
