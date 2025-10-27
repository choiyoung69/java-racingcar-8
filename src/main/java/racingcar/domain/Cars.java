package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.strategy.MoveStrategy;

public class Cars {
    private static final int MINIMUM_CAR_COUNT = 2;
    private final List<Car> cars;

    private Cars(List<String> carNames, MoveStrategy moveStrategy) {
        validateDuplicate(carNames);
        validateMinimumCarCount(carNames);
        this.cars = carNames.stream()
                .map(name -> Car.from(name, 0, moveStrategy))
                .toList();
    }

    public static Cars from(List<String> carName, MoveStrategy moveStrategy) {
        return new Cars(carName, moveStrategy);
    }

    public void moveAll() {
        cars.forEach(Car::decideToMove);
    }

    public List<Car> getCars() {
        return cars;
    }

    private void validateDuplicate(List<String> carNames) {
        Set<String> nameSet = new HashSet<>(carNames);
        if(carNames.size() != nameSet.size()) {
            throw new IllegalArgumentException("자동차 이름이 중복이면 안됩니다.");
        }
    }

    private void validateMinimumCarCount(List<String> carNames) {
        if (carNames.size() < MINIMUM_CAR_COUNT) {
            throw new IllegalArgumentException("자동차는 최소 2대 이상이어야 합니다.");
        }
    }
}
