package racingcar.domain;

public class MoveCount {
	private static final int DEFAULT_MOVE_COUNT = 0;
	private int moveCount;

	public MoveCount() {
		this.moveCount = DEFAULT_MOVE_COUNT;
	}

	public void progress() {
		this.moveCount++;
	}

	public int getMoveCount() {
		return this.moveCount;
	}

	public boolean isEqual(int moveCount) {
		return this.moveCount == moveCount;
	}
}
