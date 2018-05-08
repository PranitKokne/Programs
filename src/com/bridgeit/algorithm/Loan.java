/******************************************************************************
 *  
 *
 *  Purpose:The program calculates the monthly payment based on Principal Rate
 *  		of interest and Years .
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/


package com.bridgeit.algorithm;

import com.bridgeit.utility.Utility;

public class Loan 
{
	/*
	 * the main function takes Principal Rate of Interest
	 * and Years from user.
	 */
	public static void main(String[] args) 
	{
		Utility util = new Utility();
		
		//accepting the P R Y from user
		System.out.print("Enter the Principal amount : ");
		double principal = util.doubleInput();
		System.out.print("Enter the Rate of interest : ");
		double rateofInterest = util.doubleInput();
		System.out.print("Enter the Number of years : ");
		int noofYears = util.integerInput();
		
		//using the static function of Utility
		Utility.monthlyPayment(principal,rateofInterest,noofYears);
		
	}

}
