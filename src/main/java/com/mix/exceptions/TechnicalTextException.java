package com.mix.exceptions;

import com.mix.Runner;

import org.apache.log4j.*;

public class TechnicalTextException extends Exception {

	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(Runner.class);

	public TechnicalTextException() {
		super();
		System.out.println("BAD6");
	}

	public TechnicalTextException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
//		logger.info("...........");
		System.out.println("BAD7");
	}

	public TechnicalTextException(String message, Throwable cause) {
		super(message, cause);
		System.out.println("BAD8");
	}

	public TechnicalTextException(String message) {
		super(message);
		System.out.println("BAD9");
	}

	public TechnicalTextException(Throwable cause) {
		super(cause);
		System.out.println("BAD10");
	}

}
