package racingcar.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RandomUtilsTest {

	@RepeatedTest(100)
	@DisplayName("0_9_렌덤숫자_생성기능")
	public void create_random_number_test() {
		int randomNo = RandomUtils.getRandomNumber();
		assertThat(randomNo).isBetween(0, 9);
	}
}
