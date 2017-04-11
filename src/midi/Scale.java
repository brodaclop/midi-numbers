package midi;

import javax.sound.midi.MidiChannel;

public enum Scale {

	MAJOR(new int[]{60, 62, 64, 65, 67, 69, 71}),
	PENTATONIC(new int[]{60,63,65,68,70});
	
	private Scale(int[] scale) {
		this.scale = scale;
	}

	private int[] scale;
	
	private static int[] SCALE = {60, 62, 64, 65, 67, 69, 71};

	public void playNote(MidiChannel c, int note, int octave, int volume) {
		int key = scale[note % scale.length] + octave * 12;
		int speed = ((note & 15) << 2) + volume;
		System.out.println(note+" -> "+key+"/"+speed);
		c.noteOn(key, speed);
	}	
}
