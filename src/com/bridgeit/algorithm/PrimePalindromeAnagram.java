/******************************************************************************
 *  
 *
 *  Purpose:The program find prime numbers that are anagram and 
 *  		palindrome between 0-1000.
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/

package com.bridgeit.algorithm;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import com.bridgeit.utility.Utility;

public class PrimePalindromeAnagram 
{
	/*
	 *the main function store the prime number between 0-1000 in an primeNumbers 
	 *list prime anagram numbers in primeAnagram list and
	 *prime palindrome in primePalindrome list.
	 *in the end it find the prime number that are palindrome and anagram
	 *and store it in palindromeAnagram list and print the list.
	 * 
	 * 
	 */
			
	public static void main(String[] args) 
	{	
			List<Integer> primeNumbers = new ArrayList<Integer>();
			List<Integer> primeAnagram = new ArrayList<Integer>();
			List<Integer> primePalindrome = new ArrayList<Integer>();
			Set<Integer> palindromeAnagram = new LinkedHashSet<Integer>();
			
			//adding prime numbers from 0 to 1000 in an list
			for(int i=0;i<=1000;i++)
			{
				//using the static function of Utility
				int prime = Utility.findPrime(i);
				if(prime>0) 
				{
					primeNumbers.add(i);
				}
			}
			System.out.println(primeNumbers);
			
			//finding prime palindrome numbers and adding it to list
			for(int i=0;i<primeNumbers.size();i++) 
			{
				boolean flag = Utility.primePalindromeFinder(primeNumbers.get(i));
				if(flag) 
				{
					primePalindrome.add(primeNumbers.get(i));
				}
			}
			System.out.println(primePalindrome);
			//finding prime anagram numbers and adding it to list
			for(int i=0;i<primeNumbers.size();i++) 
			{
				for(int j=0;j<primeNumbers.size();j++) 
				{
					if(i!=j && (Integer.toString(primeNumbers.get(i))).length()==Integer.toString(primeNumbers.get(j)).length())
					{
						boolean flag = Utility.primeAnagramFinder(primeNumbers.get(i),primeNumbers.get(j));
						if(flag) 
						{
							//count++;
							primeAnagram.add(primeNumbers.get(i));
						}
					}
				}
			}
			System.out.println(primeAnagram);
			//System.out.println(count);
			
			for(int i=0;i<primePalindrome.size();i++) 
			{
				for(int j=0;j<primeAnagram.size();j++) 
				{
					if(primePalindrome.get(i)==primeAnagram.get(j)) 
					{
						palindromeAnagram.add(primePalindrome.get(i));
					}
				}
			}
			System.out.println(palindromeAnagram);
		}

		

	

}
