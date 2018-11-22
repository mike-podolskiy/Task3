package com.mix.elements;

import java.util.ArrayList;

import com.mix.manager.MessageManager;


public class Paragraph extends ArrayList<Sentence> implements TextItem {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(
				MessageManager.getInstance().getString("delimiter.paragraph"));
		for (Sentence s : this) {
			sb.append(s.toString() + 
					MessageManager.getInstance().getString("delimiter.sentence"));
		}	
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	
}
