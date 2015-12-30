package kz.enu.podolskii.runner;

//import kz.enu.podolskii.exceptions.LogicalTextException;
import kz.enu.podolskii.elements.Text;
import kz.enu.podolskii.manager.MessageManager;
import kz.enu.podolskii.parser.TextParser;
import kz.enu.podolskii.service.io.IOServiceImpl;
import kz.enu.podolskii.service.text.TextServiceImpl;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Runner {

	static MessageManager manager;
	static final Logger logger;
	static final String LOGGER_PROPERTY_FILE;

	static {
		manager = MessageManager.getInstance();
		logger = Logger.getLogger(Runner.class);
		LOGGER_PROPERTY_FILE = "resources/log4j.properties";
	}

	public static void main(String[] args) {

		PropertyConfigurator.configure(LOGGER_PROPERTY_FILE);
		IOServiceImpl ioServiceImpl = new IOServiceImpl();
		String str = ioServiceImpl.readText(MessageManager.INPUT);
		Text text = TextParser.parseText(str);
		ioServiceImpl.writeText(MessageManager.OUTPUT, text.toString());
		TextServiceImpl textServiceImpl = new TextServiceImpl();
		textServiceImpl.printWords(textServiceImpl
				.getWordsInAlphabeticalOrder(text));
	}
}
