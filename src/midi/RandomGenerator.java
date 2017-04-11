package midi;

import java.util.Random;

public class RandomGenerator implements Generator {

	private final Random rnd;

	public RandomGenerator(int seed) {
		this.rnd = new Random(seed);
	}
	
	public long next() {
		return rnd.nextInt(Integer.MAX_VALUE);
	}
	
}
