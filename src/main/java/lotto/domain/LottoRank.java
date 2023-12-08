package lotto.domain;

import java.util.List;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int rank;
    private final int prize;

    LottoRank(int rank, int prize) {
        this.rank = rank;
        this.prize = prize;
    }

    public LottoRank rank(LottoTickets lottoTickets, List<Integer> winningNumbers) {
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            int count = (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
            for (LottoRank lottoRank : values()) {
                if (lottoRank.rank == count) {
                    return lottoRank;
                }
            }
        }
    }
}
