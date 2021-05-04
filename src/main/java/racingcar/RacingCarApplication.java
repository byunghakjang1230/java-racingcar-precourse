package racingcar;

import racingcar.controller.RacingController;

public class RacingCarApplication {
	public static void main(String[] args) {
		RacingController controller = new RacingController();
		controller.initRacing();
		controller.startRacing();
		controller.endRacing();
	}
}
