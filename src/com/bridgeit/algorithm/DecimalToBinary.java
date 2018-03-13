/******************************************************************************
 *  
 *
 *  Purpose:Decimal to Binary conversion.
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/



package com.bridgeit.algorithm;

import java.util.Scanner;
import com.bridgeit.utility.Utility;

public class DecimalToBinary
{
	/*
	 * main function takes decimal number 
	 * as a input 
	 * 
	 */
	public static void main(String[] args) 
	{
		Utility util = new Utility();
		System.out.print("Enter the Decimal Number : ");
		int decimalNumber = util.integerInput();
		
		//using the static function of Utility
		Utility.toBinary(decimalNumber);
	}

}
