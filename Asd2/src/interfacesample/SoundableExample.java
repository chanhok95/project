package interfacesample;

public class SoundableExample {
	private static void printSound(Soundalbe soundable) {
		System.out.println(soundable.sound());
	}

	public static void main(String[] args) {
		printSound(new Cat());
		printSound(new Dog());

	}
}
