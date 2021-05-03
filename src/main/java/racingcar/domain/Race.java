package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Race {
	public static final String SPLIT_REGEX = ",";
	public static final int MIN_RACING_COUNT = 1;
	private final List<Car> carList;
	private int racingCount;

	public Race() {
		this.carList = new ArrayList<>();
		this.racingCount = 0;
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

	public void setRacingCount(int racingCount) {
		validateRacingCount(racingCount);
		this.racingCount = racingCount;
	}

	public int getRacingCount() {
		return this.racingCount;
	}

	private void validateDuplicationCarName(String[] carNames) {
		Set<String> validSet = new HashSet<>();
		validSet.addAll(Arrays.asList(carNames));
		if (validSet.size() != carNames.length) {
			throw new IllegalArgumentException("중복된 자동차 이름이 입력되었습니다.");
		}
	}

	private void validateRacingCount(int racingCount) {
		if (racingCount < MIN_RACING_COUNT) {
			throw new IllegalArgumentException("이동 횟수는 1 이상의 양의 정수만 가능합니다.");
		}
	}
}
