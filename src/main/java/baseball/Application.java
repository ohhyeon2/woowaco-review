package baseball;

import static baseball.domain.Retry.restartAndQuit;
import static baseball.domain.Rules.isThreeStrike;

import static baseball.util.RandomGenerator.createRandomNumbers;

import static baseball.view.InputView.input;
import static baseball.view.InputView.inputRetry;
import static baseball.view.OutputView.baseballGameEndMessage;
import static baseball.view.OutputView.inputNumberMessage;
import static baseball.view.OutputView.strikeAndBallCountMessage;

import baseball.domain.Rules;
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
        while (!isThreeStrike()) {
            inputNumberMessage();
            final List<Integer> input = input();
            final Rules rules = new Rules(input, randomNumbers);
            strikeAndBallCountMessage(rules.getStrike(), rules.getBall());
        }
    }
}
