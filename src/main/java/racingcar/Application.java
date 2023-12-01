package racingcar;

import static racingcar.view.InputView.inputCar;
import static racingcar.view.InputView.inputRound;
import static racingcar.view.OutputView.printInputCarNameMessage;
import static racingcar.view.OutputView.printInputRoundMessage;
import static racingcar.view.OutputView.printRaceResultMessage;
import static racingcar.view.OutputView.printRaceWinnerMessage;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.domain.RaceWinner;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}

class Game {

    public void start() {
        printInputCarNameMessage();

        List<Car> cars = new ArrayList<>();
        for (String car : inputCar()) {
            cars.add(new Car(car));
        }

        printInputRoundMessage();
        Race race = new Race(cars, inputRound());

        printRaceResultMessage();
        race.startRace();

        RaceWinner raceWinner = new RaceWinner(race);
        printRaceWinnerMessage(raceWinner.getWinners());

    }
}