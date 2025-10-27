package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.Parser.CommaParser;
import racingcar.domain.Parser.Parser;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Parser parser = new CommaParser();
        RacingGameController racingGameController = new RacingGameController(parser);
        racingGameController.gameStart();
    }
}
