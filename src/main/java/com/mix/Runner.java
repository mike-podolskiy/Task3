package com.mix;

//import LogicalTextException;
import com.mix.elements.Text;
import com.mix.manager.MessageManager;
import com.mix.parser.TextParser;
import com.mix.service.io.IOServiceImpl;
import com.mix.service.text.TextServiceImpl;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Runner {

	static MessageManager manager;
	static final Logger logger;
	static final String LOGGER_PROPERTY_FILE;

	static {
		manager = MessageManager.getInstance();
		logger = Logger.getLogger(Runner.class);
		LOGGER_PROPERTY_FILE = "log4j.properties";
	}

	public static void main(String[] args) {

//		PropertyConfigurator.configure(LOGGER_PROPERTY_FILE);
		IOServiceImpl ioServiceImpl = new IOServiceImpl();
		String str = ioServiceImpl.readText(MessageManager.INPUT);
		Text text = TextParser.parseText(str);
		ioServiceImpl.writeText(MessageManager.OUTPUT, text.toString());
		TextServiceImpl textServiceImpl = new TextServiceImpl();
		textServiceImpl.printWords(textServiceImpl
				.getWordsInAlphabeticalOrder(text));
	}
}
