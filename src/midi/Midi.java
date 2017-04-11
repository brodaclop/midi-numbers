package midi;

import java.util.stream.IntStream;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class Midi {

	
	public static void main(String[] args) throws MidiUnavailableException, InterruptedException {
		Synthesizer s = MidiSystem.getSynthesizer();
		try {
			s.open();
			MidiChannel c_left = s.getChannels()[0];
			c_left.controlChange(10, 0);
			c_left.allNotesOff();
			MidiChannel c_right = s.getChannels()[1];
			c_right.controlChange(10, 127);
			c_right.allNotesOff();
			delay();

			//1793
			//9051
			//15407
			CollatzGenerator generator = new CollatzGenerator(77031);
			//PrimeGenerator generator = new PrimeGenerator(10000);
			Scale scale = Scale.MAJOR;
			
			
			IntStream.generate(generator::next).forEach(i -> {
				scale.playNote(c_left, i,0, 64); 
				scale.playNote(c_right, i,-2, 0); 
				delay();	
			});
			
		} finally {
			s.close();
		}
	}

	private static void delay() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {}
	}
	

	
}
