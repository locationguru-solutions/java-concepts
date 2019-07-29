package com.locationguru.learning.advance;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Futures
{
	private static final Logger logger = LogManager.getLogger(Futures.class);


	public static void main(final String[] args) throws ExecutionException, InterruptedException
	{
		final CompletableFuture<String> future = new CompletableFuture<>();

		future.whenComplete((s, throwable) -> {
			try
			{
				Thread.sleep(10_000);
				logger.info("Received : {}", s);
			}
			catch (final Exception e)
			{
				logger.error(e.getMessage(), e);
			}
		});

		future.whenCompleteAsync((s, throwable) -> {
			logger.info("Received : {}", s);
		});

		new Thread(() -> future.complete(Thread.currentThread().getName())).start();
		new Thread(() -> future.completeAsync(() -> Thread.currentThread().getName())).start();

		logger.info("Got result : {}", future.get());
	}

}
