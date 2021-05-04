package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {
	private static final String SPLIT_REGEX = ",";
	private Cars cars;
	private RacingCount racingCount;

	public void createCars(String carNames) {
		List<Car> tempCarList = new ArrayList<>();
		for (String carName : carNames.split(SPLIT_REGEX)) {
			tempCarList.add(new Car(carName));
		}
		this.cars = new Cars(tempCarList);
	}

	public void setRacingCount(int racingCount) {
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
}
