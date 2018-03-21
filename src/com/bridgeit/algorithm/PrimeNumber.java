/******************************************************************************
 *  
 *
 *  Purpose:The program finds the prime number between 0 to 1000.
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/


package com.bridgeit.algorithm;

import com.bridgeit.utility.Utility;

public class PrimeNumber 
{
	/*
	 * the main function prints the prime number between 
	 * 0 to 1000.
	 */
	public static void main(String[] args)
	{
		
		for(int i=0;i<=1000;i++)
		{
			//using the static function of Utility
			int prime = Utility.findPrime(i);
			if(prime>1) 
			{
				System.out.print(prime+" ");
			}
		}
	}

}
