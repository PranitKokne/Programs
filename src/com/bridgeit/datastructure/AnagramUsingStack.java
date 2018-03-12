/**
 * Purpose :The program adds the prime numbers that are anagram between 0-1000
 * 			into a stack and prints the anagram in reverse order.	
 * 
 * @author Pranit_Kokne
 * @version 1.0
 * @since 11-03-2018
 */

package com.bridgeit.datastructure;

import java.util.ArrayList;
import java.util.List;

import com.bridgeit.utility.Utility;

public class AnagramUsingStack {

	/**
	 * the main function finds the prime number between 0-1000 and stores
	 * them in an array list.then it finds the prime numbers that are anagram 
	 * and push them into a stack.later it perform the pop operation.
	 * 
	 */
	public static void main(String[] args) 
	{
		MyStack<Integer> mystack = new MyStack<Integer>();
		List<Integer> primeNumbers = new ArrayList<Integer>();
		
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
		//System.out.println(primeNumbers);
		
		//finding prime anagram numbers and adding it to queue
		for(int i=0;i<primeNumbers.size();i++) 
		{
			for(int j=0;j<primeNumbers.size();j++) 
			{
				if(i!=j && (Integer.toString(primeNumbers.get(i))).length()==Integer.toString(primeNumbers.get(j)).length())
				{
					boolean flag = Utility.primeAnagramFinder(primeNumbers.get(i),primeNumbers.get(j));
					if(flag) 
					{
						mystack.push(primeNumbers.get(i));
					}
				}
			}
		}
		
		System.out.println(mystack.size());
		System.out.println(mystack.isEmpty());
		int entries = mystack.size();
		//printing the anagram in reverse order.
		for(int i=0;i<entries;i++) 
		{
			System.out.println(mystack.pop());
		}
		System.out.println(mystack.isEmpty());	
		System.out.println(mystack.size());
		

	}

		

	}

