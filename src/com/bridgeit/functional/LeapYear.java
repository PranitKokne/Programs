/******************************************************************************
 *  
 *
 *  Purpose: Finding the year is a leap year or not.
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/

package com.bridgeit.functional;

import java.util.Scanner;
import com.bridgeit.utility.Utility;

public class LeapYear {

	/*
	 *the main function is taking year as a input and
	 *ensuring that it is a 4 digit number or not 
	 * 
	 */
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while(flag)
		{
			//accepting the year as a input
			System.out.println("Enter the valid year...");
			int year = scanner.nextInt();
			
			//finding its length 
			int length = Integer.toString(year).length();
			if(length==4) 
			{
				//using static function of Utility 
				Utility.checkLeapYear(year);
				flag = false;
			}
		}		
		

	}

}
