package racingcar.utils;

import java.util.Random;

public class RandomUtils {
	private static final int MAX_BOUND = 10;

	public static int getRandomNumber() {
		return new Random().nextInt(MAX_BOUND);
	}
}
