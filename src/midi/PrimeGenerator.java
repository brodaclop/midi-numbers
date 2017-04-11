package midi;

import java.util.Arrays;

public class PrimeGenerator {

	private final int [] sieve;
	private int idx = 0;

	public PrimeGenerator(int size) {
		this.sieve = new int[size];
		for (int i = 2; i < size; i++) {
			sieve[i] = i;
		}
		for (int i = 2; i < size; i++) {
			for (int j = 2*i; j < size; j += i) {
				sieve[j] = 0;
			}
		}
		Arrays.stream(sieve).filter(i -> i != 0).forEach(System.out::println);
	}
	
	public int next() {
		while (idx < sieve.length) {
			if (sieve[idx] == 0) {
				idx++;
			} else {
				return sieve[idx++]+1;
			}
		}
		return 0;
	}
	
}
