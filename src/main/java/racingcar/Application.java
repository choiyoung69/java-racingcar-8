package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.Parser.CommaParser;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGameController racingGameController = new RacingGameController(new CommaParser());
        racingGameController.gameStart();
    }
}
