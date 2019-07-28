package com.locationguru.learning.basics;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdvanceSorting
{
	private static final Logger logger = LogManager.getLogger(AdvanceSorting.class);

	public static void main(final String[] args)
	{
		final List<Integer> integers = new ArrayList<>(List.of(8, 9, 10, 1, 2, 3));


		logger.info("Integers : {}", integers);
	}


}
