package com.locationguru.learning.basics;

public class HashCodeAndEquals
{
	/**
	 * Assuming object properties remain the same -
	 * <p>
	 * 1. this method must always return same value
	 * 2. if a.equals(b) is true then a.hasCode() == b.hashCode() is also true
	 * 3. if a.equals(b) is false
	 * then a.hasCode() == b.hashCode() can either be true / false
	 *
	 * @return hash code
	 */
	@Override
	public int hashCode()
	{
		return 0;
	}

	/**
	 *
	 */
	@Override
	public boolean equals(final Object obj)
	{
		return this == obj;
	}
}


