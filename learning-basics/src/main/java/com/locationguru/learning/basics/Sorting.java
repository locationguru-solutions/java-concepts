package com.locationguru.learning.basics;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sorting
{
	private static final Logger logger = LogManager.getLogger(Sorting.class);

	public static void main(final String[] args)
	{
		// Collections.sort(new ArrayList<User>());
		Collections.sort(new ArrayList<SortableUser>());
	}

	public static class SortableUser
			implements Comparable<SortableUser>
	{
		private int age;

		@Override
		public int compareTo(final SortableUser o)
		{
			return age - o.age;
		}
	}

	public static class User
	{


	}


}
