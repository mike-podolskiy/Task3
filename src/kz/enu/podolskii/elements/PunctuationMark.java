package kz.enu.podolskii.elements;

public class PunctuationMark implements TokenItem {
	
	private char punctMark;
	
	public PunctuationMark(char punctMark) {
		this.punctMark = punctMark;
	}

	@Override
	public String toString() {
		return Character.toString(punctMark);
	}
	
}
