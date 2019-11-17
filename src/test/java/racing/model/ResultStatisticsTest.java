package racing.model;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.controller.RacingGame;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultStatisticsTest {
    @DisplayName("우승자를 찾는다.")
    @Test
    void findWinnersFromGameResult() {
        List<String> carNames = Lists.newArrayList("moomin", "baedi", "comac", "JM", "EZ");
        RacingGame racingGame = new RacingGame(carNames, () -> true);
        racingGame.proceed();
        ResultStatistics resultStatistics = new ResultStatistics(racingGame.getCars());
        List<RacingCar> winners = resultStatistics.findWinners();
        assertThat(winners).isEqualTo(racingGame.getCars());
    }
}