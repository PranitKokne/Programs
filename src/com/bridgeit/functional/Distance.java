/******************************************************************************
 *  
 *
 *  Purpose:The program takes two integer arguments x and y 
 *  		and prints the Euclidean distance from the point (x, y) to the origin (0, 0).
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/

package com.bridgeit.functional;

import com.bridgeit.utility.Utility;

public class Distance 
{
	/*
	 * the main function takes the value of x and y from user.
	 */
	public static void main(String[] args) 
	{
		Utility util = new Utility();
		
		System.out.print("Enter the value of x :");
		int x = util.integerInput();
		
		System.out.print("Enter the value of y :");
		int y = util.integerInput();
		
		//using the static function of Utility.
		Utility.euclideanDistance(x,y);
	}

}
