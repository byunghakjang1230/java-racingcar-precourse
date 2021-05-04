package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Race {
	private static final String SPLIT_REGEX = ",";
	private final Cars cars;
	private final RacingCount racingCount;

	public Race(String carNames, int racingCount) {
		this.cars = createCars(carNames);
		this.racingCount = new RacingCount(racingCount);
	}

	public int getCarCount() {
		return this.cars.getCarsCount();
	}

	public int getRacingCount() {
		return this.racingCount.getRacingCount();
	}

	public Cars moveCars() {
		this.cars.moveCars();
		return this.cars;
	}

	public List<String> getWinnerNameList() {
		return this.cars.getWinnerNameList();
	}

	private Cars createCars(String carNames) {
		List<Car> tempCarList = new ArrayList<>();
		for (String carName : carNames.split(SPLIT_REGEX)) {
			tempCarList.add(new Car(carName));
		}
		return new Cars(tempCarList);
	}
}
