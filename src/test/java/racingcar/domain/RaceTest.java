package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {

    private List<Car> cars;
    private Race race;

    @DisplayName("레이스 카 생성")
    @BeforeEach
    void createRaceCar() {
        cars = Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3"));
        race = new Race(cars, 5);
    }

    @DisplayName("시도 회수 0 입력")
    @Test
    void minRoundExceptionTest() {
        assertThatThrownBy(() -> new Race(cars, 0)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("라운드는 최소 1회 이상을 입력해야 한다.");
    }

    @DisplayName("시도 회수 10회 초과")
    @Test
    void maxRoundExceptionTest() {
        assertThatThrownBy(() -> new Race(cars, 11)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("라운드는 10회를 넘길 수 없다.");
    }

    @DisplayName("레이스 결과 표시")
    @Test
    void raceResultTest() {
        race.startRace();
        assertNotNull(race.winner());
    }
}