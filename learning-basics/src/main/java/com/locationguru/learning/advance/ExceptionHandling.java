package com.locationguru.learning.advance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExceptionHandling
{
	private static final Logger logger = LogManager.getLogger(ExceptionHandling.class);

	public static void main(String[] args)
	{
		try
		{
			throw new NoClassDefFoundError();
		}
		catch (final Throwable e)
		{
			logger.error(e.getMessage(), e);
		}

		logger.info("After error ..");
	}

}
