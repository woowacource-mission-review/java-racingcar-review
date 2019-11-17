import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CarTest {
    private CarName name;

    @BeforeEach
    void setUp() {
        CarName name = new CarName("comac");
    }

    @Test
    @DisplayName("자동차의 이름을 가지고 자동차 객체를 정상적으로 생성한다.")
    void create_car() {
        assertDoesNotThrow(() -> new Car(name));
    }

    @Test
    @DisplayName("자동차의 초기 위치는 0이다.")
    void init_car_position() {
        Car car = new Car(name);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("랜덤 숫자가 4이상이면 자동차는 현재 위치에서 한 칸 움직일 수 있다.")
    void can_move_car() {
        Car car = new Car(name);
        assertThat(car.getPosition()).isEqualTo(0);
        car.move(new ForwardMoveStrategy());
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
