package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.Input.money;
import static lotto.view.Output.printInputMoneyMessage;
import static lotto.view.Output.printLottoTicketsMessage;
import static lotto.view.Output.printTicketCountMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.domain.LottoTickets;

public class Application {
    public static void main(String[] args) {
        printInputMoneyMessage();

        final LottoTickets lottoTickets = new LottoTickets(money());

        printTicketCountMessage(lottoTickets.count());
        printLottoTicketsMessage(lottoTickets);

        final List<Integer> winningNumbers = new ArrayList<>();
        // 로또 번호 입력
        winningNumbers.add(Integer.parseInt(readLine()));
        // 보너스 번호 입력
        winningNumbers.add(Integer.parseInt(readLine()));

        Set<Integer> duplicate = new HashSet<>(winningNumbers);
        if (duplicate.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("중복된 수를 입력할 수 없습니다.");
        }

    }
}