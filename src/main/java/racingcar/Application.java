package racingcar;

import static racingcar.view.InputView.inputCar;
import static racingcar.view.InputView.inputRound;
import static racingcar.view.OutputView.printInputCarNameMessage;
import static racingcar.view.OutputView.printInputRoundMessage;
import static racingcar.view.OutputView.printRaceWinnerMessage;
import static racingcar.view.OutputView.printResultMessage;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.domain.RaceWinner;

public class Application {
    public static void main(String[] args) {
        final Game game = new Game();
        game.start();
    }
}

class Game {

    public void start() {
        printInputCarNameMessage();
        final List<Car> cars = inputCar();

        printInputRoundMessage();
        final Race race = new Race(cars, inputRound());

        printResultMessage();
        race.startRace();

        final RaceWinner raceWinner = new RaceWinner(race);
        printRaceWinnerMessage(raceWinner);
    }
}