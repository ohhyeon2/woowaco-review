package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class InputView {

    public static List<Car> inputCar() {
        final List<Car> cars = new ArrayList<>();
        for (String car : readLine().split(",")) {
            cars.add(new Car(car));
        }
        return cars;
    }

    public static int inputRound() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력 가능합니다.");
        }
    }
}
