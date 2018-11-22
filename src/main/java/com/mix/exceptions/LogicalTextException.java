package com.mix.exceptions;

import com.mix.Runner;

import org.apache.log4j.Logger;

public class LogicalTextException extends Exception {

	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(Runner.class);

	public LogicalTextException() {
		super();
		System.out.println("BAD1");
	}

	public LogicalTextException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
//		logger.info("...........");
		System.out.println("BAD2");
	}

	public LogicalTextException(String message, Throwable cause) {
		super(message, cause);
		System.out.println("BAD3");
	}

	public LogicalTextException(String message) {
		super(message);
		System.out.println("BAD4");
	}

	public LogicalTextException(Throwable cause) {
		super(cause);
		System.out.println("BAD5");
	}

}
