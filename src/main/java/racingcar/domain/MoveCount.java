package racingcar.domain;

public class MoveCount {
	private int moveCount;

	public MoveCount() {
		this.moveCount = 0;
	}

	public void progress() {
		this.moveCount++;
	}

	public int getMoveCount() {
		return this.moveCount;
	}
}
