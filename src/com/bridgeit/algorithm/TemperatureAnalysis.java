/******************************************************************************
 *  
 *
 *  Purpose:the program performs the celsius to fahrenheit 
 *  		and vice versa conversion.
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/

package com.bridgeit.algorithm;

import com.bridgeit.utility.Utility;

public class TemperatureAnalysis 
{
	/*
	 * the main function takes temperature in celsius or fahrenheit
	 * as a input.
	 */
	public static void main(String[] args) 
	{
		Utility util = new Utility();
		System.out.println("Press 1 for Celsius to Fahrenheit conversion :");
		System.out.println("Press 2 for Fahrenheit to Celsius conversion :");
		
		while(true) 
		{
			System.out.println("Enter your choice : ");
			int choice =util.integerInput();
			double temp;
			String tempType;
			switch(choice) 
			{
			case 1 :
				System.out.print("Enter the temperature in Celsius : ");
				temp = util.doubleInput();
				tempType = "Celsius";
				
				//using the static function of Utility
				Utility.temperatureConversion(temp,tempType);
				break;
				
			case 2 :
				System.out.print("Enter the temperature in Fahrenheit : ");
				temp = util.doubleInput();
				tempType="Fahrenheit";
				
				//using the static function of Utility
				Utility.temperatureConversion(temp,tempType);
				break;
				
			default :
					System.exit(0);
			}
		}
	}

}
