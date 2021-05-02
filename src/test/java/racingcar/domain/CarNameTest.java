package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {

	@Test
	@DisplayName("자동차객체_생성_테스트")
	public void create_car_test() {
		CarName carName1 = new CarName("a");
		CarName carName2 = new CarName("abcde");
		assertThat(carName1.getCarName()).isEqualTo("a");
		assertThat(carName2.getCarName()).isEqualTo("abcde");

		assertThatIllegalArgumentException().isThrownBy(() -> {
			CarName exceptionCar1 = new CarName("");
		});
		assertThatIllegalArgumentException().isThrownBy(() -> {
			CarName exceptionCar2 = new CarName("abcdef");
		});
	}
}
