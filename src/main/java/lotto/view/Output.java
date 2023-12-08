package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;

public class Output {

    public static void printInputMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printTicketCountMessage(int tickets) {
        System.out.println(tickets + "개를 구매했습니다.");
    }

    public static void printLottoTicketsMessage(LottoTickets lottoTickets) {
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
