package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NameTest {

    @Test
    void 논리적_동치성_테스트() {
        final Name name1 = Name.of("베디");
        final Name name2 = Name.of("베디");

        assertThat(name1).isEqualTo(name2);
    }

    @Test
    void 이름_2자_미만_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> Name.of("a"));
    }

    @Test
    void 이름_5자_초과_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> Name.of("abcdef"));
    }
}