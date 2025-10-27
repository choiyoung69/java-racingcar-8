package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.MoveStrategy;

class CarTest {

    static class AlwaysMoveStrategy implements MoveStrategy {
        @Override
        public boolean isAllowedToAdvance() {
            return true;
        }
    }

    static class NeverMoveStrategy implements MoveStrategy {
        @Override
        public boolean isAllowedToAdvance() {
            return false;
        }
    }

    @Test
    @DisplayName("전진 조건이 true일 때 한 칸 이동")
    void move_allowed() {
        Car car = Car.from("pobi", 0, new AlwaysMoveStrategy());

        car.decideToMove();

        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("전진 조건이 false일 때 한 칸 이동")
    void move_not_allowed() {
        Car car = Car.from("pobi", 0, new NeverMoveStrategy());

        car.decideToMove();

        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 이름이 비어있으면 예외가 발생한다")
    void carName_isEmtpy() {
        assertThatThrownBy(() -> Car.from(" ", 0, new NeverMoveStrategy()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 비어있으면 안됩니다");
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과하면 예외가 발생한다")
    void carName_isOverThanFive() {
        assertThatThrownBy(() -> Car.from("seoyoung", 0, new NeverMoveStrategy()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5글자 이하여야 합니다");
    }

    @Test
    @DisplayName("자동차 이름이 정상일 경우 예외가 발생하지 않는다")
    void validCarName() {
        assertThatCode(() -> Car.from("pobi",0, new NeverMoveStrategy()))
                .doesNotThrowAnyException();
    }
}