package midi;

public class PascalGenerator implements Generator {

	private final int size;
	public int idx;
	
	public PascalGenerator(int size) {
		this.size = size;
	}

	private long choose(int k, int n) {
		long ret = 1;
		for (int i = n-k; i < n; i++) {
			ret *= i == 0 ? 1 : i;
		}
		for (int i = 1; i <= k; i++) {
			ret /= i;
		}
		return ret;
	}
	
	@Override
	public long next() {
		return choose(idx++, size);
	}

}
