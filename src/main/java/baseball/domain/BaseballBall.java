package baseball.domain;

import java.util.List;

public class BaseballBall implements IBaseballReferee{

    @Override
    public int baseballReferee(List<Integer> input, List<Integer> randomNumbers) {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNumbers.contains(input.get(i)) && !randomNumbers.get(i).equals(input.get(i)))
                ballCount++;
        }
        return ballCount;
    }
}
