package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.MoveStrategy;

class CarsTest {

    static class AlwaysMoveStrategy implements MoveStrategy {
        @Override
        public boolean isAllowedToAdvance() {
            return true;
        }
    }

    @Test
    @DisplayName("자동차 이름이 중복되면 예외가 발생한다")
    void duplicatedName() {
        // given
        List<String> duplicateNames = List.of("pobi", "woni", "pobi");

        // when & then
        assertThatThrownBy(() -> Cars.from(duplicateNames, new AlwaysMoveStrategy()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 중복이면 안됩니다");
    }

    @Test
    @DisplayName("자동차가 2대 미만이면 예외가 발생한다")
    void createCars_WithLessThanTwoCars() {
        List<String> singleCar = List.of("pobi");

        // when & then
        assertThatThrownBy(() -> Cars.from(singleCar, new AlwaysMoveStrategy()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차는 최소 2대 이상이어야 합니다");
    }

    @DisplayName("정상적인 자동차 목록이면 Cars 객체가 정상 생성된다")
    @Test
    void createValidCars() {
        List<String> validNames = List.of("pobi", "woni", "jun");

        assertThatCode(() -> Cars.from(validNames, new AlwaysMoveStrategy()))
                .doesNotThrowAnyException();
    }
}