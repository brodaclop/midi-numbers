package midi;

public class CollatzGenerator implements Generator {

	private long value;

	public CollatzGenerator(long value) {
		this.value = value;
	}
	
	public long next() {
		return value = ((value & 1) == 0 ? value : value*3+1) >> 1; 
	}
	
}
