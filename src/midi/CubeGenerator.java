package midi;

public class CubeGenerator implements Generator {

	private int idx = 0;
	
	@Override
	public long next() {
		long res = idx*idx*idx;
		idx++;
		return res;
	}

}
