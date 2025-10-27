package racingcar.domain;

import java.util.List;

public class Game {
    private final Cars cars;
    private final int totalRounds;
    private int currentRound;

    private Game(Cars cars, int totalRounds) {
        validatePositiveRounds(totalRounds);
        this.cars = cars;
        this.totalRounds = totalRounds;
        this.currentRound = 0;
    }

    public static Game from(Cars cars, int totalRounds) {
        return new Game(cars, totalRounds);
    }

    public void playOneRound() {
        cars.moveAll();
        currentRound++;
    }

    public boolean hasNextRound() {
        return currentRound < totalRounds;
    }

    public Cars getCars() {
        return cars;
    }

    public List<Car> getWinner() {
        int maxDistance = cars.getCars().stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        return cars.getCars().stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
    }

    private void validatePositiveRounds(int totalRounds) {
        if(totalRounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이여야 합니다.");
        }
    }
}
