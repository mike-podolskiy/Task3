package com.mix.service.text;

import java.util.ArrayList;

import com.mix.elements.Word;
import com.mix.elements.Sentence;
import com.mix.elements.Text;

//import LogicalTextException;

public interface TextService {

	ArrayList<Word> getWordsInAlphabeticalOrder(Text text);

	void printSentences(ArrayList<Sentence> s);

	void printWords(ArrayList<Word> w);
}
