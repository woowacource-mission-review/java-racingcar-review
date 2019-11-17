package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class WinnerTest {

    private CarName name = new CarName("comac");
    private Car car;

    @BeforeEach
    void setup() {
        car = new Car(name);
    }

    @Test
    @DisplayName("우승자를 정상적으로 생성한다.")
    void create_winner() {
        assertDoesNotThrow(() -> new Winner(car));
    }

    @Test
    @DisplayName("우승자 이름을 확인한다.")
    void check_winner_name() {
        Winner winner = new Winner(car);
        assertThat(winner.getWinnerName()).isEqualTo("comac");
    }
}
