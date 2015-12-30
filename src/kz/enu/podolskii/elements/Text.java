package kz.enu.podolskii.elements;

import java.util.ArrayList;

import kz.enu.podolskii.manager.MessageManager;


public class Text extends ArrayList<TextItem> {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();	
		for (TextItem item : this) {
			sb.append(item.toString() + 
					MessageManager.getInstance().getString("delimiter.text"));
		}	
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
}
