package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] car = Console.readLine().split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(Console.readLine());

        System.out.println();
        List<Car> cars = new ArrayList<>();
        for (String carName : car) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없다.");
            }
            cars.add(new Car(carName));
        }

        System.out.println("실행 결과");
        Race race = new Race(cars, count);
        race.start();

        List<String> winners = race.winner();
        StringBuilder sb = new StringBuilder();
        for (String winner : winners) {
            sb.append(winner).append(", ");
        }

        if (sb.length() > 1) {
            sb.setLength(sb.length() -2);
        }
        System.out.println("최종 우승자 : " + sb);

    }


}

class Car {

    private final String car;
    private int position;

    public Car(String car) {
        this.car = car;
        this.position = 0;
    }

    public String getCarName() {
        return car;
    }

    public int getCarPosition() {
        return position;
    }

    public void movePosition() {
        this.position++;
    }

}

class Race {

    private List<Car> cars;
    private int rounds;

    public Race(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public void start() {
        for (int i = 0; i < rounds; i++) {
            race();
        }
    }

    private void race() {
        for (Car car : cars) {
            if (position()) {
                car.movePosition();
            }
            System.out.println(car.getCarName() + ": " + "-".repeat(car.getCarPosition()));
        }
        System.out.println();
    }

    private boolean position() {
        return Randoms.pickNumberInRange(0, 9) > 3;
    }

    public List<String> winner() {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getCarPosition() == maxPosition()) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    private int maxPosition() {
        return cars.stream().mapToInt(Car::getCarPosition).max().orElse(0);
    }

}