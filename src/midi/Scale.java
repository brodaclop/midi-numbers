package midi;

import javax.sound.midi.MidiChannel;

public enum Scale {

	MAJOR(new int[]{60, 62, 64, 65, 67, 69, 71}),
	PENTATONIC(new int[]{60,63,65,68,70});
	
	private Scale(int[] scale) {
		this.scale = scale;
	}

	private int[] scale;
	
	public void playNote(MidiChannel c, long note, int octave, int volume) {
		int idx = (int)(note % scale.length);
		int key = scale[idx] + octave * 12;
		int speed = (int)(((note & 15) << 2) + volume);
		System.out.println(note+" -> "+key+"/"+speed);
		c.noteOn(key, speed);
	}	
}
