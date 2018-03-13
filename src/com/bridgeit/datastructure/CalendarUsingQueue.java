package com.bridgeit.datastructure;

import com.bridgeit.utility.Utility;

public class CalendarUsingQueue {

	public static void main(String[] args) {
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
		Utility.calendarPrintUsingQueue(startDay,numberofDays,year,month);

	}

}
