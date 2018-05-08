/******************************************************************************
 *  
 *
 *  Purpose: performing the prime factorization of a number.
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/


package com.bridgeit.functional;

import java.util.ArrayList;
import java.util.List;
import com.bridgeit.utility.Utility;
public class Factors
{
	/*
	 * the main function takes a number as input and 
	 * prints its prime factorization as a output	
	 */
	
	public static void main(String[] args) 
	{
		//define the dynamic array to store the prime factorization of a number 
		List<Integer> primeFactorization = new ArrayList<Integer>();
		Utility util = new Utility();
		System.out.println("Enter the number");
		int number = util.integerInput();
		int result = Utility.findPrime(number);
		int num = number;
		//checking entered number is prime or not 
		if(result>0) 
		{
			System.out.print("The entered number "+number+" itself is a prime number \n");
			System.out.println("Prime factorization : "+"1*"+number);
		}
		else 
		{
			//if the number is not a prime number 
			//so we are performing prime factorization
			
			for(int i=2;i<=num/2;i++) 
			{
				if(Utility.findPrime(i)>0) 
				{	
					while(number%i==0)
					{
						number=number/i;
						primeFactorization.add(i);
					}
				}
			}
			System.out.println(primeFactorization);
			
		}
	}

}
