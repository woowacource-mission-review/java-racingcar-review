package model.result;

import model.AlwaysTrueMoveStrategy;
import model.Car;
import model.MoveDeterminer;
import model.RacingCars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoundResultsTest {
    private MoveDeterminer moveDeterminer = new MoveDeterminer(new AlwaysTrueMoveStrategy());

    @Test
    @DisplayName("RoundResults 동작 확인")
    void round_results() {
        RoundResults roundResults = new RoundResults();
        int abcPosition = 2;
        int defPosition = 3;
        List<Car> cars = Arrays.asList(new Car("ABC", abcPosition), new Car("DEF", defPosition));
        RacingCars racingCars = new RacingCars(cars, moveDeterminer);
        int round = 3;

        for (int i = 1; i <= round; i++) {
            roundResults.addRoundResult(racingCars.moveCars());
            RoundResult roundResult = roundResults.getRoundResult(i);
            assertTrue(roundResult.contains(new MoveResult("ABC", abcPosition + i)));
            assertTrue(roundResult.contains(new MoveResult("DEF", defPosition + i)));
        }
    }
}
