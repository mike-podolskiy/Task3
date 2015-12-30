package kz.enu.podolskii.elements;

import java.util.ArrayList;

public class Token extends ArrayList<TokenItem> {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (TokenItem t : this) {
			sb.append(t.toString());
		}	
		return sb.toString();
	}

}
