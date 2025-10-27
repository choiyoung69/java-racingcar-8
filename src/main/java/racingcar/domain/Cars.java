package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars = new ArrayList<>();

    private Cars(List<String> carNames) {
        carNames.stream()
                .map(name -> Car.from(name, 0, new RandomMoveStrategy));
    }
}
