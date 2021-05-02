package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoveCountTest {

	@Test
	@DisplayName("이동횟수_증가_테스트")
	public void move_count_progress_test() {
		MoveCount moveCount = new MoveCount();
		moveCount.progress();
		moveCount.progress();
		assertThat(moveCount.getMoveCount()).isEqualTo(2);
	}
}
