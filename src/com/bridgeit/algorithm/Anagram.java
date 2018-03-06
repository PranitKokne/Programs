/******************************************************************************
 *  
 *
 *  Purpose:The program ensure that the one string is an anagram of 
 *  		another or not.One string is an anagram of another if 
 *  		the second is simply a rearrangement of the first.
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/

package com.bridgeit.algorithm;

import java.util.Scanner;
import com.bridgeit.utility.Utility;

public class Anagram 
{
	/*
	 * the main function takes two strings as a input 
	 * convert the strings to lower case
	 * and check if the length of strings are same or not
	 * it also removes the extreme spaces and spaces between 
	 * words.
	 */
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		//accepting two words from user
		System.out.print("Enter the first word : ");
		String word1 = scanner.nextLine();
		
		System.out.print("Enter the second word : ");
		String word2 = scanner.nextLine();
		
		word1=word1.toLowerCase();
		word2=word2.toLowerCase();
		
		if(word1.length() == word2.length()) 
		{
			//using the static function of Utility
			Utility.checkAnagram(word1,word2);
		}
		else 
		{
			word1=word1.trim().replaceAll(" ", "");
			word2=word2.trim().replaceAll(" ", "");
			if(word1.length()==word2.length()) 
			{
				Utility.checkAnagram(word1,word2);
			}
		}
		
	}

}
