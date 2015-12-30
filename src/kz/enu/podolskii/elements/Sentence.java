package kz.enu.podolskii.elements;

import java.util.ArrayList;

import kz.enu.podolskii.manager.MessageManager;


public class Sentence extends ArrayList<Token> {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Token t : this) {
			sb.append(t + MessageManager.getInstance().getString("delimiter.sentence"));
		}
		sb.deleteCharAt(sb.length()-1);
		
		return sb.toString();
	}

}

