package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCountTest {

	@Test
	@DisplayName("이동횟수_관리_클래스_생성")
	public void create_racing_count_test() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			RacingCount racingCount = new RacingCount(0);
		});
		RacingCount racingCount = new RacingCount(1);
		assertThat(racingCount.getRacingCount()).isEqualTo(1);
	}
}
