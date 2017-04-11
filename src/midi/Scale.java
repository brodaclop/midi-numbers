package midi;

import java.util.Arrays;

public class Scale {

	private static final int [] MAJOR_NOTES = {0, 2, 4, 5, 7, 9, 11};
	private static final int [] PENTATONIC_NOTES = {0,3,5,8,10};

	public static final Scale MAJOR = majorBuilder().build();
	public static final Scale DORIAN = majorBuilder().rotate(1).build();
	public static final Scale PHRYGIAN = majorBuilder().rotate(2).build();
	public static final Scale LYDIAN = majorBuilder().rotate(3).build();
	public static final Scale MIXOLYDIAN = majorBuilder().rotate(4).build();
	public static final Scale AEOLIAN = majorBuilder().rotate(5).build();
	public static final Scale LOCRIAN = majorBuilder().rotate(5).build();

	
	public static class Builder {
		private int[] scale;

		private Builder(int[] scale) {
			this.scale = scale;
		}
		
		public Builder transpose(int steps) {
			for (int i = 0; i < scale.length; i++) {
				scale[i] += steps;
			}
			return this;
		}
		
		public Builder rotate(int steps) {
			int [] result = new int[scale.length];
			for (int i = 0; i < scale.length; i++) {
				int newpos = (i+steps) % scale.length;
				result[newpos] = scale[i]+(newpos > i ? 12 : 0);
			}
			this.scale = result;
			transpose(-scale[0]);
			return this;
		}
		
		public Scale build() {
			return new Scale(scale);
		}
	}

	public static Builder majorBuilder() {
		return new Builder(MAJOR_NOTES);
	}

	public static Builder pentatonicBuilder() {
		return new Builder(PENTATONIC_NOTES);
	}
	
	
	private Scale(int[] scale) {
		this.scale = scale;
		System.out.println(Arrays.toString(scale));
	}

	private final int[] scale;
	
	public int note(long num) {
		return scale[(int)(num % scale.length)];
	}
}
