/**
 * Purpose :The program prints the calendar of the month.
 * 
 * @author Pranit_Kokne
 * @version 1.0
 * @since 08-03-2018
 *
 */

package com.bridgeit.datastructure;

import com.bridgeit.utility.Utility;

public class Calendar {
	/*
	 * main function takes the month and year as a input and
	 * based on the input finds out the year is leap or not and
	 * the number of days in a particular month and in the 
	 * end prints the calendar of the month.
	 */
	public static void main(String[] args) 
	{
		int numberofDays;
		Utility util = new Utility();
		
		System.out.println("Enter the month : ");
		int month = util.integerInput();
		System.out.println("Enter the year : ");
		int year = util.integerInput();
		
		//using the static function of Utility
		boolean type = Utility.yearType(year);
		
		if(type) 
		{
			numberofDays=Utility.leapYear(month);
		}
		else 
		{
			numberofDays=Utility.normalYear(month);
		}
		System.out.println(numberofDays);
		
		//finding the start day of month 0 to 6
		int startDay = Utility.dayOfWeek(month, 1, year);
		System.out.println(startDay);
		
		//call the calendar print method		
		Utility.calendar(startDay,numberofDays,year,month);
	}

}
