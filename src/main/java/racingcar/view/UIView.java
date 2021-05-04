package racingcar.view;

import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

import racingcar.domain.Cars;

public class UIView {
	private final Scanner scanner;

	public UIView() {
		this.scanner = new Scanner(System.in);
	}

	public String displayAndInputCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		return this.scanner.nextLine();
	}

	public int displayAndInputRacingCount() {
		System.out.println("시도할 회수는 몇회인가요?");
		return this.scanner.nextInt();
	}

	public void displayStartRacing() {
		System.out.println("");
		System.out.println("실행 결과");
	}

	public void displayResult(Cars cars) {
		for (String carName : cars.getCarNameList()) {
			int moveCount = cars.getMoveCountByCarName(carName);
			System.out.printf("%s : %s\n", carName, changeCountToLine(moveCount));
		}
		System.out.println("");
	}

	public void displayWinners(List<String> winnerNameList) {
		StringJoiner joiner = new StringJoiner(", ");
		for (String carName : winnerNameList) {
			joiner.add(carName);
		}
		System.out.printf("%s가 최종 우승했습니다.\n", joiner.toString());
	}

	private String changeCountToLine(int moveCount) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < moveCount; i++) {
			stringBuilder.append("-");
		}
		return stringBuilder.toString();
	}
}
