package midi;

public class FibonacciGenerator implements Generator {

	private long value;
	private long previous;

	public FibonacciGenerator(int value) {
		this.previous = 0;
		this.value = value;
	}
	
	public long next() {
		if (value > 0) {
			long temp = value;
			value = value+previous;
			previous = temp;
			if (value > 0) {
				return value; 
			}
		}
		return 0;
	}
	
}
