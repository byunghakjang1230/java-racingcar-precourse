package racingcar.domain;

public class CarName {
	private static final int CAR_NAME_LENGTH_MIN = 1;
	private static final int CAR_NAME_LENGTH_MAX = 5;
	private final String carName;

	public CarName(String carName) {
		validateNameLength(carName.trim());
		this.carName = carName.trim();
	}

	public String getCarName() {
		return this.carName;
	}

	private void validateNameLength(String carName) {
		if (carName.length() < CAR_NAME_LENGTH_MIN || carName.length() > CAR_NAME_LENGTH_MAX) {
			throw new IllegalArgumentException("자동차의 이름은 1~5자리만 가능합니다.");
		}
	}
}
