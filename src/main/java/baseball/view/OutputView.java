package baseball.view;

public class OutputView {

    public static void inputNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void strikeAndBallCountMessage(int strike, int ball) {
        StringBuffer sb = new StringBuffer();

        if (ball != 0) {
            sb.append(ball).append("볼");
        }

        if (strike != 0) {
            sb.append(strike).append("스트라이크");
        }

        if (strike != 0 || ball != 0) {
            System.out.println(sb);
        }
        threeStrikeCountMessage(strike);
    }

    public static void threeStrikeCountMessage(int strike) {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public static void inputRetryOrQuitButtonMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void nothingCountMessage(int nothing) {
        if (nothing == 0) {
            System.out.println("낫싱");
        }
    }
}
