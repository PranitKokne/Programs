/**
 * Purpose :The program finds the prime number between 0-1000 and stores them 
 * 			in a 2 Dimensional array where the first dimension represent the 
 * 			range like 0-100,100-200 and so on. and the second dimension represent 
 * 			the prime number in that range.
 * 
 * @author Pranit_Kokne
 * @version 1.0
 * @since 09-03-2018
 */

package com.bridgeit.datastructure;

import com.bridgeit.utility.Utility;

public class PrimeNumbers {
	/*
	 * main function first finds the column size of a jagged array
	 * then it finds the prime number between 0-1000 and stores them 
	 * in 2 Dimensional array and later print the 2D array.
	 */
	public static void main(String[] args) 
	{
		//defining the jagged array
		int[][] prime = new int[10][];
		
		//counting the columns of each row of a jagged array
		Utility.columnCountof2DArray(prime);
		
		//storing the prime numbers into 2 D array
		Utility.storePrimes(prime);
		
		//printing the prime number stored in 2D array
		Utility.jaggedArrayPrint(prime, prime.length);
	}

}
