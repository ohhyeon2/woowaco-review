package racingcar.domain;

import static racingcar.domain.RandomGenerator.randomNumber;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> cars;
    private int rounds;

    public Race(List<Car> cars, int rounds) {
        validateRound(rounds);
        this.cars = cars;
        this.rounds = rounds;
    }

    public void startRace() {
        for (int i = 0; i < rounds; i++) {
            for (Car car : cars) {
                if (position()) {
                    car.movePosition();
                }
                System.out.println(car.getCarName() + ": " + "-".repeat(car.getCarPosition()));
            }
            System.out.println();
        }
    }

    private boolean position() {
        return randomNumber() > 3;
    }

    public List<String> winner() {
        List<String > winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getCarPosition() == maxPosition()) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    private int maxPosition() {
        return cars.stream().mapToInt(Car::getCarPosition).max().orElse(0);
    }

    private void validateRound(int rounds) {
        validateMaxRound(rounds);
        validateMinRound(rounds);
    }

    private void validateMinRound(int rounds) {
        if (rounds < 1) {
            throw new IllegalArgumentException("라운드는 최소 1회 이상을 입력해야 한다.");
        }
    }

    private void validateMaxRound(int rounds) {
        if (rounds > 10) {
            throw new IllegalArgumentException("라운드는 10회를 넘길 수 없다.");
        }
    }
}
