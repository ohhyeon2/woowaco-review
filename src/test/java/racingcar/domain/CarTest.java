package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @DisplayName("테스트 차량 생성")
    @BeforeEach
    void createCar() {
        car = new Car("test");
    }

    @DisplayName("차량 이름 정상 입력")
    @Test
    void createCarSuccessTest() {
        Car testCar = new Car("valid");
        assertThat(testCar.getCarName()).isEqualTo("valid");
    }

    @DisplayName("차량 초기 위치 0")
    @Test
    void carPositionInitSuccessTest() {
        assertEquals(0, car.getCarPosition());
    }

    @DisplayName("차량 한 칸 이동")
    @Test
    void movePositionSuccessTest() {
        car.movePosition();
        assertEquals(1, car.getCarPosition());
    }

    @DisplayName("차량 이름 5글자 초과")
    @Test
    void createCarFailTest() {
        assertThatThrownBy(() -> new Car("invalid")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자를 초과할 수 없다.");
    }

}