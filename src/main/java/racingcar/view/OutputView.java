package racingcar.view;

import java.util.List;
import java.util.StringJoiner;

import racingcar.domain.Car;
import racingcar.domain.RaceWinner;

public class OutputView {

    public static void printInputCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printInputRoundMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printRaceResultMessage(final List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("%s: %s\n", car.getCarName(), "-".repeat(car.getCarPosition()));
        }
        System.out.println();
    }

    public static void printRaceWinnerMessage(final RaceWinner winners) {
        StringJoiner joiner = new StringJoiner(", ");
        for (String winner : winners.getWinners()) {
            joiner.add(winner);
        }
        System.out.println("최종 우승자 : " + joiner);
    }
}
