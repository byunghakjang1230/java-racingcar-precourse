package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import racingcar.utils.RandomUtils;

public class Cars {
	private static final int FIRST_ELEMENT_INDEX = 0;
	private final List<Car> carList;

	public Cars(List<Car> carList) {
		validateDuplicationCarName(carList);
		this.carList = carList;
	}

	public int getCarsCount() {
		return this.carList.size();
	}

	public void moveCars() {
		this.carList.forEach(car -> car.tryMove(RandomUtils.getRandomNumber()));
	}

	public List<String> getCarNameList() {
		List<String> carNameList = new ArrayList<>();
		this.carList.forEach(car -> carNameList.add(car.getCarName()));
		return carNameList;
	}

	public int getMoveCountByCarName(String carName) {
		Map<String, Integer> carsMap = new HashMap<>();
		this.carList.forEach(car -> carsMap.put(car.getCarName(), car.getMoveCount()));
		return carsMap.get(carName);
	}

	public List<String> getWinnerNameList() {
		List<String> winnerList = new ArrayList<>();
		this.carList.forEach(car -> addWinnerCarName(winnerList, car));
		return winnerList;
	}

	public int getMaxMoveCount() {
		List<Integer> countList = new ArrayList<>();
		this.carList.forEach(car -> countList.add(car.getMoveCount()));
		countList.sort(Comparator.reverseOrder());
		return countList.get(FIRST_ELEMENT_INDEX);
	}

	private void validateDuplicationCarName(List<Car> carList) {
		Set<String> validSet = new HashSet<>();
		carList.forEach(car -> validSet.add(car.getCarName()));
		if (validSet.size() != carList.size()) {
			throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
		}
	}

	private void addWinnerCarName(List<String> winnerList, Car car) {
		if (car.isEqualMoveCount(getMaxMoveCount())) {
			winnerList.add(car.getCarName());
		}
	}
}
