package kz.enu.podolskii.elements;

import java.util.ArrayList;

public class Listing extends ArrayList<Sentence> implements TextItem {
	
	private static final long serialVersionUID = 1L;
	
	private String listing;
	
	public Listing(String listing) {
		this.listing = listing;
	}

	@Override
	public String toString() {
		return listing;
	}
}
