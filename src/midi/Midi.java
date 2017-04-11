package midi;

import java.util.Arrays;
import java.util.stream.LongStream;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class Midi {

	
	public static void main(String[] args) throws MidiUnavailableException, InterruptedException {
		Synthesizer s = MidiSystem.getSynthesizer();
		try {
			s.open();
			Instrument bass = s.getLoadedInstruments()[45];
			Instrument solo = s.getLoadedInstruments()[14];
			System.out.println("bass: "+bass);
			System.out.println("solo: "+solo);
			Scale scale = Scale.MAJOR;
			Player left = Player.create(s.getChannels()[0], scale, 4, 0, bass);
			Player right = Player.create(s.getChannels()[1], scale, 6, 127, solo);
			delay();

			//1793
			//9051
			//15407
			//CollatzGenerator generator = new CollatzGenerator(77031);
			//PrimeGenerator generator = new PrimeGenerator(10000);
			//FibonacciGenerator generator = new FibonacciGenerator(1);
			//RandomGenerator generator = new RandomGenerator(0);
			Generator generator = new FibonacciGenerator(1);
			
			
			LongStream.generate(generator::next).forEach(i -> {
				left.playNote(i,64); 
				right.playNote(i, 0); 
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
