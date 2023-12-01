package racingcar.domain;

public class RaceWinner {

    private final String winners;

    public RaceWinner(Race race) {
        this.winners = winners(race);
    }

    private String winners(Race race) {
        StringBuilder sb = new StringBuilder();
        for (String winner : race.winner()) {
            sb.append(winner).append(",").append(" ");
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() -2);
        }
        return sb.toString();
    }

    public String getWinners() {
        return winners;
    }
}
