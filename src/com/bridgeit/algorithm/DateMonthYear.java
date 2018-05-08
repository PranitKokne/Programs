/******************************************************************************
 *  
 *
 *  Purpose:the program takes month day and year as a input and 
 *  		prints the day of the week.
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/

package com.bridgeit.algorithm;

import com.bridgeit.utility.Utility;

public class DateMonthYear 
{
	/*
	 * the main function takes the month day and year as a
	 * input ensure that the values are valid or not.
	 */
	public static void main(String[] args) 
	{
		int d0=-1;
		Utility util = new Utility();
		boolean flag = true;
		
		while(flag)
		{
			System.out.print("Enter the month : ");
			int m = util.integerInput();
			System.out.print("Enter the day : ");
			int d = util.integerInput();
			System.out.print("Enter the year : ");
			int y = util.integerInput();
			
			
			if(m<=12 && d<=31 && Integer.toString(y).length()==4)
			{
				//using the static function of Utility
				d0=Utility.dayOfWeek(m,d,y);
				flag=false;
			}
			else 
			{
				System.out.println("Invalid day or month or year :");
			}
			
		}
		
		String[] days = new String[]{"sunday","monday","tuesday","wednesday","thrusday","friday","saturday"};
		
		System.out.println("day : "+days[d0]);

	}

}
