package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static int money() {
        final int money = Integer.parseInt(Console.readLine());
        try {
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("1000원 단위의 금액만 입력 가능합니다.");
            }
            return divMoney(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return money();
        }
    }

    private static int divMoney(int money) {
        return money / 1000;
    }
}
