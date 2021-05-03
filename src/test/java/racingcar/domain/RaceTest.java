package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {

	@Test
	@DisplayName("자동차_리스트_생성")
	public void create_cars_test() {
		Race race1 = new Race();
		race1.createCars("abc,def,ghi");
		assertThat(race1.getCarCount()).isEqualTo(3);

		Race race2 = new Race();
		assertThatIllegalArgumentException().isThrownBy(() -> {
			race2.createCars("abc,def,abc");
		});
	}
}
