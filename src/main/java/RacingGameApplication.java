import controller.RacingGameController;
import view.InputView;
import view.OutputView;

public class RacingGameApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        RacingGameController racingGameController = new RacingGameController(inputView, outputView);
        try {
            racingGameController.start();
        } catch (RuntimeException e) {
            outputView.showErrorMessage(e);
        }
    }
}
