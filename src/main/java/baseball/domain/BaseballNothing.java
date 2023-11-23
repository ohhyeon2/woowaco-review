package baseball.domain;

import java.util.List;

public class BaseballNothing implements IBaseballReferee {

    @Override
    public int baseballReferee(List<Integer> input, List<Integer> randomNumbers) {
        for (Integer inputNumbers : input) {
            if (randomNumbers.contains(inputNumbers)) {
                return 1;
            }
        }
        return 0;
    }

}
