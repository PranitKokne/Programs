/******************************************************************************
 *  
 *
 *  Purpose:the program convert decimal number into binary number
 *  		then swaps the nibble of the binary number after swapping 
 *  		it convert the swapped binary number into decimal and ensure
 *  		that the decimal number is a power of 2 or not.
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/

package com.bridgeit.algorithm;

import java.util.Scanner;
import com.bridgeit.utility.Utility;


public class Binary 
{
	/*
	 * main function takes the decimal number as a input
	 * from user
	 */
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the Decimal Number : ");
		int decimalNumber = scanner.nextInt();
		
		//using the static method of Utility
		Utility.binaryConversion(decimalNumber);
	}
	
	
	
}
