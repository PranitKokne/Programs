/**
 * Purpose :The program checks whether the input String is palindrome or not. 
 * 
 *	@author Pranit_Kokne
 *  @version 1.0 
 *	@since 08-03-2018
 */

package com.bridgeit.datastructure;

import com.bridgeit.utility.Utility;

public class PalindromeChecker {

	public static void main(String[] args) {
		Utility util = new Utility();
		
		System.out.print("Enter the String as a input : ");
		String name = util.inputString();
		
		name=name.toLowerCase();
		
		boolean result = Utility.palindromeChecker(name);
		
		if(result) 
		{
			System.out.println("The String "+name+" is a palindrome");
		}
		else 
		{
			System.out.println("The String "+name+" is not a palindrome");
		}
	}
}
