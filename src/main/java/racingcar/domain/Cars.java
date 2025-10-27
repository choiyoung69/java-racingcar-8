package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<String> carNames) {
        MoveStrategy moveStrategy = RandomMoveStrategy.getInstance();
        this.cars = carNames.stream()
                .map(name -> Car.from(name, 0, moveStrategy))
                .toList();
    }

    public static Cars from(List<String> carName) {
        return new Cars(carName);
    }

    public void race() {

    }
}
