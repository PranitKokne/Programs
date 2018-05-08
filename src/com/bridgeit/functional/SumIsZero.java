/******************************************************************************
 *  
 *
 *  Purpose:Takes n integers and counts the number of distinct triplets that
 *  		exactly sum to 0.
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/
package com.bridgeit.functional;

import com.bridgeit.utility.Utility;

public class SumIsZero 
{
	/*
	 * the main function takes the number of integers and integers
	 * from user and insert them to the number array.
	 */
	public static void main(String[] args) 
	{
		Utility util = new Utility();
		
		//accpting the size of an array
		System.out.print("Enter the size of an array : ");
		int size = util.integerInput();
		int[] number = new int[size];
		
		//inserting the values into array
		System.out.println("insert "+size+" integers into : ");
		for(int i=0;i<number.length;i++) 
		{
			number[i]= util.integerInput();
		}
		
		//using the static function of Utility
		Utility.sumEqualToZero(number);
		
	}

}
