package racingcar.view;

public class OutputView {

    private OutputView() {
    }

    public static void printExceptionMessageForPlayer(final IllegalArgumentException e) {
        System.out.println("ERROR : " + e.getMessage());
    }
}
