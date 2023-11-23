package baseball.domain;

import java.util.List;

public class BaseballStrike implements IBaseballReferee{

    @Override
    public int baseballReferee(List<Integer> input, List<Integer> randomNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNumbers.get(i).equals(input.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}
