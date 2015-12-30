package kz.enu.podolskii.elements;

public class Word implements TokenItem {

	private String word;

	public Word(String word) {
		this.word = word;
	}

	public void setWord(String str) {
		this.word = str;
	}

	@Override
	public String toString() {
		return word;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	public boolean equalsIgnoreCase(Word word) {
		return this.toString().equalsIgnoreCase(word.toString());
	}

	// public boolean firstSymbolRatio(Word word) {
	// char[] ch1 = word.toString().toLowerCase().toCharArray();
	// char[] ch2 = this.toString().toLowerCase().toCharArray();
	//
	// if (ch2[0] > ch1[0])
	// return true;
	// else
	// return false;
	// }

	public boolean firstSymbolRatio(Word word) {
		if (word.toString().substring(0, 1).toLowerCase().toCharArray()[0] < this
				.toString().substring(0, 1).toLowerCase().toCharArray()[0])
			return true;
		else
			return false;
	}

	public boolean firstSymbolEquals(String str) {
		if (this.toString().substring(0, 1)
				.equalsIgnoreCase(str.substring(0, 1)))
			return true;
		else
			return false;
	}

}
