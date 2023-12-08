package racingcar.domain;

public class Car {

    private final String car;
    private int position;

    public Car(final String car) {
        validateCarName(car);
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

    private void validateCarName(final String car) {
        if (car.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없다.");
        }
    }
}
