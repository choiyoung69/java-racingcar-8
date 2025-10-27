package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.domain.Parser.Parser;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.dto.GameRequestDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private Parser parser;

    public RacingGameController(Parser parser) {
        this.parser = parser;
    }

    public void gameStart() {
        GameRequestDto gameRequestDto = getGameRequest();
        Game game = initializeGame(gameRequestDto);

        OutputView.printExecutionResultMessage();
        playGame(game);
        printWinner(game);
    }

    private GameRequestDto getGameRequest() {
        return InputView.readGameRequest();
    }

    private Game initializeGame(GameRequestDto request) {
        List<String> carNames = parser.parse(request.carNames());
        Cars cars = Cars.from(carNames, RandomMoveStrategy.getInstance());
        return Game.from(cars, request.numberOfAttempts());
    }

    private void playGame(Game game) {
        while (game.hasNextRound()) {
            game.playOneRound();
            OutputView.printRound(game.getCars());
        }
    }

    private void printWinner(Game game) {
        OutputView.printWinner(game.getWinner());
    }
}
