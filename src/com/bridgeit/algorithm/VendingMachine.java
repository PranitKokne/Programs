/******************************************************************************
 *  
 *
 *  Purpose:There is 1, 2, 5, 10, 50, 100, 500 and 1000 Rs Notes which can be 
 *  		returned by Vending Machine.
 *  		The program finds the minimum number of Notes as well as 
 *  		the Notes to be returned by the Vending Machine as a Change.
 *  
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/

package com.bridgeit.algorithm;

import java.util.Scanner;
import com.bridgeit.utility.Utility;

public class VendingMachine 
{
	/*
	 * the main function takes the amount as a input from user
	 * 
	 */
	public static void main(String[] args) 
	{
		
		
		int[] notes = new int[]{1,2,5,10,50,100,500,1000};
		
		Utility util = new Utility();
		
		System.out.print("Enter the amount : ");
		int amount = util.integerInput();
		
		//using the static function of Utility
		Utility.numberofNotes(amount,notes);
	}

}
