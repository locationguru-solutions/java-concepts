package com.locationguru.learning.advance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Threads
{
	private static final Logger logger = LogManager.getLogger(Threads.class);

	public static void main(String[] args) throws InterruptedException
	{
		final Thread thread = new Thread(Threads::doWork);
		final Thread anotherThread = new Thread(Threads::doAnotherWork);
		final Thread someOtherThread = new Thread(Threads::doSomeOtherWork);

		thread.start();
		someOtherThread.start();

		thread.join();
		someOtherThread.join();

		anotherThread.start();
	}

	public static void doWork()
	{
		logger.info("Work done ..");
	}

	public static void doAnotherWork()
	{
		logger.info("Another work done ..");
	}

	public static void doSomeOtherWork()
	{
		logger.info("Some other work done ..");
	}

}
