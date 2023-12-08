package baseball.view;

import java.util.StringJoiner;

public class OutputView {

    public static void inputNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void strikeAndBallCountMessage(int strike, int ball) {
        StringJoiner joiner = new StringJoiner(" ");
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        if (ball != 0) {
            joiner.add(ball + "볼");
        }
        if (strike != 0) {
            joiner.add(strike + "스트라이크");
        }
        System.out.println(joiner);
    }

    public static void baseballGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}
