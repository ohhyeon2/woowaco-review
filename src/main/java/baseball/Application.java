package baseball;

import static baseball.view.InputView.input;
import static baseball.view.OutputView.inputNumberMessage;
import static baseball.view.OutputView.inputRetryOrQuitButtonMessage;
import static baseball.view.OutputView.nothingCountMessage;
import static baseball.view.OutputView.strikeAndBallCountMessage;

import baseball.domain.BaseballBall;
import baseball.domain.BaseballNothing;
import baseball.domain.BaseballStrike;
import baseball.util.RandomGenerator;
import baseball.view.InputView;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            boolean isGame = true;
            while (isGame) {
                final RandomGenerator randomGenerator = new RandomGenerator();
                final List<Integer> randomNumbers = randomGenerator.createRandomNumbers();
                System.out.println(randomNumbers);
                baseballReferee(randomNumbers);
                isGame = isRetryGame();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static void baseballReferee(List<Integer> randomNumbers) {
        while (true) {
            inputNumberMessage();

            final List<Integer> input = input();

            final int strike = new BaseballStrike().baseballReferee(input, randomNumbers);
            final int ball = new BaseballBall().baseballReferee(input, randomNumbers);
            final int nothing = new BaseballNothing().baseballReferee(input, randomNumbers);

            if (strike == 0 && ball == 0) {
                nothingCountMessage(nothing);
                continue;
            }

            strikeAndBallCountMessage(strike, ball);

            if (strike == 3) {
                break;
            }
        }
    }

    public static boolean isRetryGame() {
        inputRetryOrQuitButtonMessage();
        return Console.readLine().equals("1");
    }
}
