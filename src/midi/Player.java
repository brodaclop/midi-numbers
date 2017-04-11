package midi;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;

public class Player {
	private final MidiChannel channel;
	private final int octave;
	private final Scale scale;

	public static Player create(MidiChannel channel, Scale scale, int octave, int pan, Instrument instrument) {
		channel.programChange(instrument.getPatch().getBank(), instrument.getPatch().getProgram());
		channel.controlChange(10, pan);
		channel.allNotesOff();
		return new Player(channel, scale, octave);
	}
	
	private Player(MidiChannel channel, Scale scale, int octave) {
		this.channel = channel;
		this.octave = octave;
		this.scale = scale;
	}

	public void playNote(long note, int volume) {
		int key = scale.note(note) + octave * 12;
		int speed = (int)(((note & 15) << 2) + volume);
		System.out.println(note+" -> "+key+"/"+speed);
		channel.noteOn(key, speed);
	}
	
	
}