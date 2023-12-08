package racingcar.domain;

import static racingcar.view.OutputView.printRaceResultMessage;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Race {

    private final List<Car> cars;
    private final int rounds;

    public Race(final List<Car> cars, final int rounds) {
        validateRound(rounds);
        this.cars = cars;
        this.rounds = rounds;
    }

    public void startRace() {
        for (int round = 0; round < rounds; round++) {
            movePosition();
            printRaceResultMessage(cars);
        }
    }

    private void movePosition() {
        for (Car car : cars) {
            if (position()) {
                car.movePosition();
            }
        }
    }

    private boolean position() {
        return Randoms.pickNumberInRange(0, 9) > 3;
    }

    public List<String> winner() {
        final List<String > winners = new ArrayList<>();
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

    private void validateRound(final int rounds) {
        validateMaxRound(rounds);
        validateMinRound(rounds);
    }

    private void validateMinRound(final int rounds) {
        if (rounds < 1) {
            throw new IllegalArgumentException("라운드는 최소 1회 이상을 입력해야 한다.");
        }
    }

    private void validateMaxRound(final int rounds) {
        if (rounds > 10) {
            throw new IllegalArgumentException("라운드는 10회를 넘길 수 없다.");
        }
    }
}
