package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

	@Test
	@DisplayName("자동차_전체이동_및_결과_검증_테스트")
	public void move_all_cars_test() {
		List<Car> carList = new ArrayList<>();
		carList.add(new Car("abc"));
		carList.add(new Car("def"));
		carList.add(new Car("ghi"));
		Cars cars = new Cars(carList);

		cars.moveCars();
		cars.moveCars();
		cars.moveCars();
		cars.moveCars();
		cars.moveCars();
		cars.moveCars();

		List<String> carNameList = cars.getCarNameList();
		List<String> winnerNameList = cars.getWinnerNameList();

		List<Integer> moveCountList = new ArrayList<>();
		carNameList.forEach(name -> moveCountList.add(cars.getMoveCountByCarName(name)));
		moveCountList.sort(Comparator.reverseOrder());

		int maxMoveCount = cars.getMaxMoveCount();
		assertThat(moveCountList.get(0)).isEqualTo(maxMoveCount);

		Map<String, Integer> carsMap = new HashMap<>();
		carNameList.forEach(name -> carsMap.put(name, cars.getMoveCountByCarName(name)));

		List<String> matchedCarNameList = new ArrayList<>();
		carsMap.forEach((name, moveCount) -> {
			if (moveCount == maxMoveCount) {
				assertThat(winnerNameList.contains(name)).isTrue();
				matchedCarNameList.add(name);
			}
		});
		assertThat(winnerNameList.size()).isEqualTo(matchedCarNameList.size());
	}

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
