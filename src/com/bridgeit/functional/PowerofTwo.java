/******************************************************************************
 *  
 *
 *  Purpose: Prints the table of power of 2.
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/


package com.bridgeit.functional;

import java.util.Scanner;
import com.bridgeit.utility.Utility;

public class PowerofTwo {
	/*
	 * the main function is taking a number as a input 
	 * and ensuring that it is greater than 0 and 
	 * less than 31
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number : ");
		int number = scanner.nextInt();
		if(number>-1 && number<31)
		{
			//using the static function of Utility
			Utility.Table(number);
		}
		else
		{
			System.out.println("Enter a number between 0 and 30");
		}

	}

}
