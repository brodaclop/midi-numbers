package midi;

public class SquareGenerator implements Generator {

	private int idx = 0;
	
	@Override
	public long next() {
		int res = idx*idx;
		idx++;
		return res;
	}

}
