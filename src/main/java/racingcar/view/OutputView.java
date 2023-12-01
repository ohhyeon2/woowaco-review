package racingcar.view;

public class OutputView {

    public static void printInputCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printInputRoundMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printRaceResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printRaceWinnerMessage(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}
