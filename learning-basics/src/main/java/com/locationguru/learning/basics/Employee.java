/*
 * Project Name : Employee Tracking System Project ID : SMIT0334 Company Name :
 * LocationGuru Solutions Pvt. Ltd. History :
 * *********************************************************************************************
 * S No. Date Developers Name Description
 * *********************************************************************************************
 * 1) 2008 Kedar Joshi Created
 *
 */

package com.locationguru.learning.basics;

import java.util.Objects;

public class Employee
{
	/**
	 * The cached hash code value for this instance. Settting to 0 triggers
	 * re-calculation.
	 */
	private int hashValue = 0;

	private Long id;

	public Long getId()
	{
		return id;
	}

	/**
	 * Implementation of the hashCode method conforming to the Bloch pattern
	 * with the exception of array properties (these are very unlikely primary
	 * key types).
	 *
	 * @return int
	 */
	@Override
	public int hashCode()
	{
		if (hashValue == 0)
		{
			int result = 17;
			final int value = getId() == null ? 0 : getId().hashCode();
			result = result * 37 + value; // TODO 31 would have been better
			hashValue = result;

			// TODO OR after Java 7
			hashValue = Objects.hash(getId());

		}

		return hashValue;
	}

	/**
	 * Implementation of the equals comparison on the basis of equality of the
	 * primary key values.
	 *
	 * @param rhs Object
	 * @return boolean
	 */
	@Override
	public boolean equals(final Object rhs)
	{
		if (rhs == null)
		{
			return false;
		}

		if (!(rhs instanceof Employee))
		{
			return false;
		}

		final Employee that = (Employee) rhs;

		if ((getId() == null) || (that.getId() == null))
		{
			return false;
		}

		return (getId().equals(that.getId()));
	}
}
