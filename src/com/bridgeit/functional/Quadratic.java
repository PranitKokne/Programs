/******************************************************************************
 *  
 *
 *  Purpose:the program find the roots of the quadratic equation a*x*x + b*x + c.
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/

package com.bridgeit.functional;

import java.util.Scanner;
import com.bridgeit.utility.Utility;

public class Quadratic 
{
	/*
	 * the main function takes the coefficients of the quadratic equation as a input
	 */
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		//accpting the values of a b c from user
		System.out.print("Enter a : ");
		int a = scanner.nextInt();
		
		System.out.print("Enter b : ");
		int b = scanner.nextInt();
		
		System.out.print("Enter c : ");
		int c = scanner.nextInt();
		
		//using the static method of Utility
		Utility.roots(a,b,c);

	}

}
