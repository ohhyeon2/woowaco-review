package racingcar.domain;

import java.util.List;

public class RaceWinner {

    private final List<String> winners;

    public RaceWinner(final Race race) {
        this.winners = winners(race);
    }

    private List<String> winners(final Race race) {
        return race.winner();
    }

    public List<String> getWinners() {
        return winners;
    }
}
