package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String[] inputCar() {
        return Console.readLine().split(",");
    }

    public static int inputRound() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력 가능합니다.");
        }
    }
}
