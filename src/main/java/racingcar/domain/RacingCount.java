package racingcar.domain;

public class RacingCount {
	private static final int MIN_RACING_COUNT = 1;
	private final int racingCount;

	public RacingCount(int racingCount) {
		validateRacingCount(racingCount);
		this.racingCount = racingCount;
	}

	public int getRacingCount() {
		return this.racingCount;
	}

	private void validateRacingCount(int racingCount) {
		if (racingCount < MIN_RACING_COUNT) {
			throw new IllegalArgumentException("이동 횟수는 1 이상의 양의 정수만 가능합니다.");
		}
	}
}
