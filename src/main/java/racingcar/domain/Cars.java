package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.RandomMoveStrategy;

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
        cars.forEach(Car::decideToMove);
    }

    private void validateDuplicate(List<String> carNames) {
        Set<String> nameSet = new HashSet<>(carNames);
        if(carNames.size() != nameSet.size()) {
            throw new IllegalArgumentException("자동차 이름이 중복이면 안됩니다.");
        }
    }
}
