package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {

    public List<Integer> input() {
        final String input = Console.readLine();
        validateInput(input, inputParsing(input));
        return inputParsing(input);
    }

    private List<Integer> inputParsing(final String input) {
        List<Integer> nums = new ArrayList<>();
        for (String num : input.split("")) {
            nums.add(validateNumber(num));
        }
        return nums;
    }

    private int validateNumber(final String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("error : 숫자 외에 다른 문자의 입력은 안된다.");
        }
    }

    private void validateInput(final String input, final List<Integer> nums) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("error : 세자리의 숫자를 입력해주세요.");
        }
        if (input.length() != 3) {
            throw new IllegalArgumentException("error : 세자리의 숫자를 입력해주세요.");
        }
        Set<Integer> duplicate = new HashSet<>(nums);
        if (duplicate.size() != input.length()) {
            throw new IllegalArgumentException("error : 중복된 수는 입력할 수 없습니다.");
        }
    }
}
