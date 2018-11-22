package com.mix.manager;

import java.util.ResourceBundle;

public class MessageManager {
    
	private static final String REGEX_PROPERTY_FILE = "regex";
	public static final String INPUT = "resources/input.txt";
	public static final String OUTPUT = "resources/output.txt";
   
    private ResourceBundle bundle;
    private static MessageManager configManager;
    
    public static MessageManager getInstance() {
        if (configManager == null) {
            configManager = new MessageManager();
        }
        return configManager;
    }
    
    private MessageManager() {
        bundle = ResourceBundle.getBundle(REGEX_PROPERTY_FILE);
    }
    
    public String getString(String key) {
        return bundle.getString(key);
    }
}
