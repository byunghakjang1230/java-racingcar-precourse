package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
	private final List<Car> carList;

	public Cars(List<Car> carList) {
		validateDuplicationCarName(carList);
		this.carList = carList;
	}

	public int getCarsCount() {
		return this.carList.size();
	}

	private void validateDuplicationCarName(List<Car> carList) {
		Set<String> validSet = new HashSet<>();
		carList.forEach(car -> validSet.add(car.getCarName()));
		if (validSet.size() != carList.size()) {
			throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
		}
	}
}
