package baseball;

import static baseball.domain.BaseballGameRetry.restartAndQuit;
import static baseball.domain.BaseballGameRules.baseballCount;
import static baseball.domain.BaseballGameRules.getBaseballCount;
import static baseball.domain.BaseballGameRules.isThreeStrike;

import static baseball.util.RandomGenerator.createRandomNumbers;

import static baseball.view.InputView.input;
import static baseball.view.InputView.inputRetry;
import static baseball.view.OutputView.baseballGameEndMessage;
import static baseball.view.OutputView.inputNumberMessage;
import static baseball.view.OutputView.strikeAndBallCountMessage;

import baseball.domain.BaseballGameRules;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean gameOn = true;
        while (gameOn) {
            gameLoop(createRandomNumbers());
            baseballGameEndMessage();
            gameOn = restartAndQuit(inputRetry());
        }
    }

    public static void gameLoop(List<Integer> randomNumbers) {
        BaseballGameRules.countInit();
        while (!isThreeStrike()) {
            System.out.println(randomNumbers);
            inputNumberMessage();
            baseballCount(input(), randomNumbers);
            strikeAndBallCountMessage(getBaseballCount());
        }
    }
}
