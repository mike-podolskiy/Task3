package kz.enu.podolskii.service.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import kz.enu.podolskii.manager.MessageManager;
import kz.enu.podolskii.runner.Runner;
import org.apache.log4j.Logger;

public class IOServiceImpl implements IOService {

	static final Logger logger = Logger.getLogger(Runner.class);

	@Override
	public String readText(String src) {
		StringBuilder sb = new StringBuilder();

		try (Scanner sc = new Scanner(new File(src))) {
			while (sc.hasNext()) {
				sb.append(sc.nextLine() + "\r\n");
			}
			logger.info("File opened: input.txt");
		} catch (FileNotFoundException e) {
			logger.info(MessageManager.getInstance().getString(
					"exception.fileNotFound"));
		}
		return sb.toString();
	}

	@Override
	public void writeText(String fileName, String text) {
		try (PrintWriter pw = new PrintWriter(fileName)) {
			pw.write(text);
		} catch (FileNotFoundException e) {
			logger.info(MessageManager.getInstance().getString(
					"exception.fileNotFound"));
		}
	}
}
