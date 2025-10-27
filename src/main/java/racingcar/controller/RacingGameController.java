package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.domain.Parser.Parser;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.dto.GameRequestDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private Parser parser;
    private MoveStrategy moveStrategy;

    public void gameStart() {
        GameRequestDto gameRequestDto = InputView.readGameRequest();

        List<String> parsedCarNames = parser.parse(gameRequestDto.carNames());
        Cars cars = Cars.from(parsedCarNames, RandomMoveStrategy.getInstance());
        Game game = Game.from(cars, gameRequestDto.numberOfAttempts());

        OutputView.printExecutionResultMessage();
        while (game.hasNextRound()) {
            game.playOneRound();
            OutputView.printRound(game.getCars());
        }
    }
}
