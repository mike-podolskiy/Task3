package kz.enu.podolskii.service.text;

import java.util.ArrayList;
import kz.enu.podolskii.elements.Sentence;
import kz.enu.podolskii.elements.Text;
import kz.enu.podolskii.elements.Word;

//import kz.enu.podolskii.exceptions.LogicalTextException;

public interface TextService {

	ArrayList<Word> getWordsInAlphabeticalOrder(Text text);

	void printSentences(ArrayList<Sentence> s);

	void printWords(ArrayList<Word> w);
}
