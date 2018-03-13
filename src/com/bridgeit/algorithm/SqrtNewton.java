/******************************************************************************
 *  
 *
 *  Purpose:the program find the square root of a non-negative number
 *  		using newton's method.
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/

package com.bridgeit.algorithm;
import java.util.Scanner;
import com.bridgeit.utility.Utility;

public class SqrtNewton 
{
	/*
	 * 
	 */
	public static void main(String[] args) 
	{
		boolean flag = true;
		Utility util = new Utility();
		while(flag)
		{	
			System.out.print("Enter a non negative number : ");
			int number = util.integerInput();
			if(number>=0) 
			{
				Utility.sqrt(number);
				flag = false;
			}
		}
	}

}
