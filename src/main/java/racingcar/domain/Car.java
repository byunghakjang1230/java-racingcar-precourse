package racingcar.domain;

public class Car {
	public static final int MOVABLE_MIN_NUMBER = 4;
	private final CarName carName;
	private int moveCount;

	public Car(String carName) {
		this.carName = new CarName(carName);
		this.moveCount = 0;
	}

	public String getCarName() {
		return this.carName.getCarName();
	}

	public void tryMove(int randomNo) {
		if (randomNo >= MOVABLE_MIN_NUMBER) {
			this.moveCount++;
		}
	}

	public int getMoveCount() {
		return this.moveCount;
	}
}
