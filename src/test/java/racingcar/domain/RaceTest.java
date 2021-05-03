package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {

	@Test
	@DisplayName("자동차_리스트_생성_및_이동_횟수_입력_테스트")
	public void create_race_test() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			Race race = new Race("abc,def,ghi", 0);
		}).withMessageContaining("이동 횟수는 1 이상의 양의 정수만 가능합니다.");
		assertThatIllegalArgumentException().isThrownBy(() -> {
			Race race = new Race("abc,def,abc", 1);
		}).withMessageContaining("자동차 이름은 중복될 수 없습니다.");
		Race race = new Race("abc,def,ghi", 1);
		assertThat(race.getCarCount()).isEqualTo(3);
		assertThat(race.getRacingCount()).isEqualTo(1);
	}
}
