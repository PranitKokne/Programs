/******************************************************************************
 *  
 *
 *  Purpose:The program generates N distinct coupon numbers the user wants.

 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/

package com.bridgeit.functional;

import com.bridgeit.utility.Utility;

public class CouponNumbers {

	/*
	 * main function takes the number of coupons as a input 
	 * from the user and crates an integer array to store the 
	 * generated number of coupons
	 */
	public static void main(String[] args) 
	{
		Utility util = new Utility();
		
		System.out.print("enter the number of coupons : ");
		int distinctcoupons = util.integerInput();
				
		 
		int[] coupons = new int[distinctcoupons];
				
		Utility.couponGenerator(distinctcoupons,coupons);
		

	}

}
