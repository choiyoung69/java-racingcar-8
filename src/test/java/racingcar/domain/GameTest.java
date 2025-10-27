package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.MoveStrategy;

class GameTest {

    static class AlwaysMoveStrategy implements MoveStrategy {
        @Override
        public boolean isAllowedToAdvance() {
            return true;
        }
    }

    @Test
    @DisplayName("시도 횟수가 0 이하이면 예외가 발생한다")
    void createGame_withUnValidNumberOfAttempts() {
        Cars cars = Cars.from(List.of("pobi", "woni"), new AlwaysMoveStrategy());

        assertThatThrownBy(() -> Game.from(cars, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이여야 합니다.");
    }

    @Test
    @DisplayName("정상적인 시도 횟수로 생성되면 예외가 발생하지 않는다")
    void createGame_withValidNumberOfAttempts() {
        Cars cars = Cars.from(List.of("pobi", "woni"), new AlwaysMoveStrategy());

        Game game = Game.from(cars, 5);
        assertThat(game).isNotNull();
    }

    @Test
    @DisplayName("현재 라운드가 총 라운드보다 작을 때만 hasNextRound()는 true를 반환한다")
    void hasNextRound() {
        Cars cars = Cars.from(List.of("pobi", "woni"), new AlwaysMoveStrategy());
        Game game = Game.from(cars, 2);

        assertThat(game.hasNextRound()).isTrue();

        game.playOneRound();
        assertThat(game.hasNextRound()).isTrue();

        game.playOneRound();
        assertThat(game.hasNextRound()).isFalse();
    }

    @Test
    @DisplayName("getWinner()는 가장 멀리 간 자동차(들)를 반환한다")
    void getWinner() {
        MoveStrategy always = new AlwaysMoveStrategy();
        Cars cars = Cars.from(List.of("pobi", "woni", "jun"), always);
        Game game = Game.from(cars, 1);

        game.playOneRound();

        List<Car> winners = game.getWinner();
        assertThat(winners).hasSize(3);
        assertThat(winners).extracting(Car::getName).containsExactlyInAnyOrder("pobi", "woni", "jun");
    }
}