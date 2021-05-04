package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.view.UIView;

public class RacingController {

	private final UIView view;
	private Race race;

	public RacingController() {
		this.view = new UIView();
	}

	public void initRacing() {
		String carNames = view.displayAndInputCarNames();
		int racingCount = view.displayAndInputRacingCount();
		this.race = new Race(carNames, racingCount);
	}

	public void startRacing() {
		view.displayStartRacing();
		for (int i = 0; i < this.race.getRacingCount(); i++) {
			Cars cars = this.race.moveCars();
			view.displayResult(cars);
		}
	}

	public void endRacing() {
		view.displayWinners(this.race.getWinnerNameList());
	}
}
