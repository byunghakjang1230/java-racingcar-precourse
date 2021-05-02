package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	@DisplayName("자동차_이동_테스트")
	public void car_move_test() {
		Car car = new Car("abc");
		car.tryMove(4);
		assertThat(car.getMoveCount()).isEqualTo(1);
		car.tryMove(3);
		assertThat(car.getMoveCount()).isEqualTo(1);
	}

	@Test
	@DisplayName("자동차이름_부여_테스트")
	public void car_name_set_test() {
		Car car1 = new Car("a");
		Car car2 = new Car("abcde");
		assertThat(car1.getCarName()).isEqualTo("a");
		assertThat(car2.getCarName()).isEqualTo("abcde");

		assertThatIllegalArgumentException().isThrownBy(() -> {
			Car exceptionCar1 = new Car("");
		});
		assertThatIllegalArgumentException().isThrownBy(() -> {
			Car exceptionCar2 = new Car("abcdef");
		});
	}
}
