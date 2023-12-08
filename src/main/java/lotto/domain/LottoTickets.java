package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public LottoTickets(int divMoney) {
        this.lottoTickets = tickets(divMoney);
    }

    private List<Lotto> tickets(int divMoney) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < divMoney; i++) {
            lottoTickets.add(new Lotto(random()));
        }
        return lottoTickets;
    }

    private List<Integer> random() {
        return pickUniqueNumbersInRange(1, 45, 6);
    }

    public int count() {
        return lottoTickets.size();
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
