package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

	@Test
	@DisplayName("자동차_일급_컬렉션_중복이름_예외처리")
	public void create_car_list_exception_test() {
		List<Car> carList = new ArrayList<>();
		carList.add(new Car("abc"));
		carList.add(new Car("def"));
		carList.add(new Car("abc"));
		assertThatIllegalArgumentException().isThrownBy(() -> {
			Cars cars = new Cars(carList);
		});
	}

	@Test
	@DisplayName("자동차_일급_커렉션_생성_테스트")
	public void create_car_list_test() {
		List<Car> carList = new ArrayList<>();
		carList.add(new Car("abc"));
		carList.add(new Car("def"));
		carList.add(new Car("ghi"));
		Cars cars = new Cars(carList);
		assertThat(cars.getCarsCount()).isEqualTo(3);
	}
}
