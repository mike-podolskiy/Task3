package com.mix.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mix.elements.Listing;
import com.mix.elements.Paragraph;
import com.mix.elements.PunctuationMark;
import com.mix.elements.Sentence;
import com.mix.elements.Text;
import com.mix.elements.Token;
import com.mix.elements.Word;
import com.mix.elements.*;
import com.mix.manager.MessageManager;

public class TextParser {

	private static MessageManager manager = MessageManager.getInstance();

	public static Text parseText(String str) {
		Text text = new Text();
		
		Pattern pattern = Pattern.compile(manager.getString("regex.text"));
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			String s = matcher.group();
			System.out.println(s);
			System.out.println();
			
			if (matcher.group(1) == null) {
				text.add(parseParagraph(s));
			} else {
				text.add(new Listing(s));
			}
		}
		return text;
	}

	public static Paragraph parseParagraph(String str) {
		Paragraph paragraph = new Paragraph();
		Pattern pattern = Pattern.compile(manager.getString("regex.paragraph"));
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			String s = matcher.group();
//			System.out.println(s);
			paragraph.add(parseSentence(s));
		}
		return paragraph;
	}

	public static Sentence parseSentence(String str) {
		Sentence sentence = new Sentence();
		Pattern pattern = Pattern.compile(manager.getString("regex.sentence"));
		Matcher matcher = pattern.matcher(str);
		
		while (matcher.find()) {
			String s = matcher.group();
//			System.out.println(s);
			sentence.add(parseToken(s));
		}
		return sentence;
	}

	public static Token parseToken(String str) {
		Token token = new Token();
		Pattern pattern = Pattern.compile(manager.getString("regex.token"));
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			String s = matcher.group();
//			System.out.println(s);
			if (matcher.group(1) == null) {
				token.add(new Word(s));
			} else {
				token.add(new PunctuationMark(s.charAt(0)));
			}
		}
		return token;
	}
}