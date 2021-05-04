package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.view.UIView;

public class RacingController {
	private final UIView view;
	private final Race race;

	public RacingController() {
		this.view = new UIView();
		this.race = new Race();
	}

	public void initRacing() {
		String carNames = view.displayAndInputCarNames();
		this.race.createCars(carNames);
		int racingCount = view.displayAndInputRacingCount();
		this.race.setRacingCount(racingCount);
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
