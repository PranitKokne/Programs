/**
 * Purpose :The program prints the Nth harmonic number.
 * 			 
 * @author Pranit_Kokne
 * @version 1.0
 * @since 05-03-2018
 *
 */

package com.bridgeit.functional;

import com.bridgeit.utility.Utility;

public class HarmonicNumber {
	/*
	 *the main function takes N as a input and ensures that is it not equal to 0  
	 */
	public static void main(String[] args) 
	{
		boolean flag = true;
		Utility util = new Utility();
		while(flag) 
		{
			System.out.println("Enter the value of N :");
			int N = util.integerInput();
			if(N != 0) 
			{
				Utility.harmonicValue(N); 
				flag = false;
			}
			else 
			{
				System.out.println("Please enter the value of N greater than 0 ");
			}
		}

	}

}
