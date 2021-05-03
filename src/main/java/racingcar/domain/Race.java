package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Race {
	public static final String SPLIT_REGEX = ",";
	private final List<Car> carList;

	public Race() {
		this.carList = new ArrayList<>();
	}

	public void createCars(String carNames) {
		String[] carNamesArr = carNames.split(SPLIT_REGEX);
		validateDuplicationCarName(carNamesArr);
		for (String carName : carNamesArr) {
			this.carList.add(new Car(carName));
		}
	}

	public int getCarCount() {
		return this.carList.size();
	}

	private void validateDuplicationCarName(String[] carNames) {
		Set<String> validSet = new HashSet<>();
		validSet.addAll(Arrays.asList(carNames));
		if (validSet.size() != carNames.length) {
			throw new IllegalArgumentException("중복된 자동차 이름이 입력되었습니다.");
		}
	}
}
