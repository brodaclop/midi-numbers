package midi;

public class CollatzGenerator {

	private int value;

	public CollatzGenerator(int value) {
		this.value = value;
	}
	
	public int next() {
		return value = ((value & 1) == 0 ? value : value*3+1) >> 1; 
	}
	
}
