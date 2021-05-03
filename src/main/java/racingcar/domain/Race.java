package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {
	public static final String SPLIT_REGEX = ",";
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

	private Cars createCars(String carNames) {
		List<Car> tempCarList = new ArrayList<>();
		for (String carName : carNames.split(SPLIT_REGEX)) {
			tempCarList.add(new Car(carName));
		}
		return new Cars(tempCarList);
	}
}
