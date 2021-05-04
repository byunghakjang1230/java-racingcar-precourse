package racingcar.domain;

public class Car {
	private static final int MOVABLE_MIN_NUMBER = 4;
	private final CarName carName;
	private final MoveCount moveCount;

	public Car(String carName) {
		this.carName = new CarName(carName);
		this.moveCount = new MoveCount();
	}

	public String getCarName() {
		return this.carName.getCarName();
	}

	public void tryMove(int randomNo) {
		if (randomNo >= MOVABLE_MIN_NUMBER) {
			this.moveCount.progress();
		}
	}

	public int getMoveCount() {
		return this.moveCount.getMoveCount();
	}

	public boolean isEqualMoveCount(int moveCount) {
		return this.moveCount.isEqual(moveCount);
	}
}
