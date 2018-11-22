package com.mix.service.text;

import java.util.ArrayList;

import com.mix.elements.Paragraph;
import com.mix.elements.Sentence;
import com.mix.elements.Text;
import com.mix.elements.TextItem;
import com.mix.elements.Token;
import com.mix.elements.TokenItem;
import com.mix.elements.Word;
import com.mix.exceptions.LogicalTextException;
import com.mix.manager.MessageManager;
import com.mix.Runner;
import com.mix.elements.*;

import org.apache.log4j.Logger;

public class TextServiceImpl implements TextService {

	static final Logger logger = Logger.getLogger(Runner.class);

	public ArrayList<Word> getWordsInAlphabeticalOrder(Text text) {
		ArrayList<Word> words = getAllWordsOfText(text);

		try {
			if (words.isEmpty()) {
				throw new LogicalTextException(MessageManager.getInstance()
						.getString("exception.noSentences"));
			}
		} catch (LogicalTextException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < words.size(); i++) {
			for (int j = i + 1; j < words.size(); j++) {
				if (words.get(i).firstSymbolRatio(words.get(j))) {
					Word temp = words.get(i);
					words.set(i, words.get(j));
					words.set(j, temp);
				}
			}
		}

		boolean redline = false;
		String str = words.get(0).toString().substring(0, 1);
		words.get(0).setWord("\t".concat(words.get(0).toString()));
		for (int i = 1; i < words.size(); i++) {
			if (!words.get(i).firstSymbolEquals(str)) {
				redline = true;
				str = words.get(i).toString().substring(0, 1);
			}
			if (redline) {
				words.get(i).setWord("\t".concat(words.get(i).toString()));
			}
			redline = false;
		}
		return words;
	}

	@Override
	public void printSentences(ArrayList<Sentence> s) {
		for (Sentence sentence : s) {
			logger.info(sentence);
		}
	}

	public void printWords(ArrayList<Word> w) {
		for (Word word : w) {
			logger.info(word);
		}
	}

	private static ArrayList<Word> getAllWordsOfText(Text text) {
		ArrayList<Word> words = new ArrayList<>();
		ArrayList<Sentence> sentences = getAllSentences(text);

		for (int i = 0; i < sentences.size(); i++) {
			for (Token token : sentences.get(i)) {
				for (TokenItem item : token) {
					if (item instanceof Word) {
						words.add((Word) item);
					}
				}
			}
		}
		return words;
	}

	private static ArrayList<Sentence> getAllSentences(Text text) {
		ArrayList<Sentence> sentences = new ArrayList<>();
		for (TextItem item : text) {
			if (item instanceof Paragraph) {
				for (Sentence sentence : (Paragraph) item) {
					sentences.add(sentence);
				}
			}
		}
		return sentences;
	}
}
