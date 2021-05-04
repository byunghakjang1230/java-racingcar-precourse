package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {


	@Test
	@DisplayName("자동차_이동_및_결과출력_테스트")
	public void start_racing_test() {
		Race race = new Race("abc,def,ghi", 1);
		race.moveCars();
		race.moveCars();
		race.moveCars();
		race.moveCars();
		Cars finalCar = race.moveCars();
		assertThat(finalCar.getCarsCount()).isEqualTo(3);

		List<String> carNameList = finalCar.getCarNameList();
		List<String> winnerNameList = finalCar.getWinnerNameList();

		List<Integer> moveCountList = new ArrayList<>();
		carNameList.forEach(name -> moveCountList.add(finalCar.getMoveCountByCarName(name)));
		moveCountList.sort(Comparator.reverseOrder());

		int maxMoveCount = finalCar.getMaxMoveCount();
		assertThat(moveCountList.get(0)).isEqualTo(maxMoveCount);

		Map<String, Integer> carsMap = new HashMap<>();
		carNameList.forEach(name -> carsMap.put(name, finalCar.getMoveCountByCarName(name)));

		List<String> matchedCarNameList = new ArrayList<>();
		carsMap.forEach((name, moveCount) -> {
			if (moveCount == maxMoveCount) {
				assertThat(winnerNameList.contains(name)).isTrue();
				matchedCarNameList.add(name);
			}
		});
		assertThat(winnerNameList.size()).isEqualTo(matchedCarNameList.size());
	}

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
