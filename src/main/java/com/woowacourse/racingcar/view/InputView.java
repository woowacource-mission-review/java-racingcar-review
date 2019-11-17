package com.woowacourse.racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputStr(InputMessage inputMessage) {
        System.out.println(inputMessage.getMessage());
        return SCANNER.nextLine();
    }
}
