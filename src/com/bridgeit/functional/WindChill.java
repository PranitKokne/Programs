/******************************************************************************
 *  
 *
 *  Purpose:the program takes two inputs temperature in Fahrenheit and 
 *  		wind speed in miles per hour and prints the WindChill using 
 *  		the standard formula.
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/

package com.bridgeit.functional;

import java.util.Scanner;
import com.bridgeit.utility.Utility;


public class WindChill 
{
	/*
	 * the main function takes t and v as a inputs then 
	 * ensures it satisfies the predefined conditions or not 
	 * 
	 */
	public static void main(String[] args) 
	{
		boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		while(flag) 
		{
			System.out.println("Enter the value of temperature : ");
			double t = scanner.nextDouble();
			
			System.out.println("Enter the value of velocity : ");
			double v = scanner.nextDouble();
			
			if(t<50 && (v<120 && v>3)) 
			{
				//using the static function of Utility
				Utility.windChillCalculator(t,v);
				flag = false;
			}
			else 
			{
				System.out.println("The value of temperature should be less than 50 Fahrenheit");
				System.out.println("The value of velcity should be less than 120 mph and greater than 3 mph");
				System.out.println("So enter the value according to it.");
			}
		}
		
	}

}
