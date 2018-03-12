/**
 * Purpose :The program finds the prime numbers that are anagram in the range of 0-1000.
 * 			and stores the prime anagrams in the 2 dimensional array.
 * 
 * @author Pranit_Kokne
 * @version 1.0
 * @since 12-03-2018
 *
 */

package com.bridgeit.datastructure;

import java.util.ArrayList;
import com.bridgeit.utility.Utility;

public class PrimeAnagramIn2D 
{
	/*
	 * static variable COL1,COL2 and so on are declared to keep a 
	 * count of number of entries in dynamic array.
	 */
	static int COL1=0;   static int COL6=0;						 
	static int COL2=0;   static int COL7=0;
	static int COL3=0;	 static int COL8=0;
	static int COL4=0;	 static int COL9=0;
	static int COL5=0;   static int COL10=0;
	
	/*
	 * static variable COUNT1,COUNT2 and so on are declared to insert 
	 * the anagrams into a proper row.
	 */
	static int COUNT1 = 0;	static int COUNT2 = 0;
	static int COUNT3 = 0;	static int COUNT4 = 0;
	static int COUNT5 = 0;	static int COUNT6 = 0;
	static int COUNT7 = 0;	static int COUNT8 = 0;
	static int COUNT9 = 0;	static int COUNT10 = 0;
	
	
	
	/**
	 * the function counts the number of elements in row.
	 * @param number is the prime number between 0-1000 
	 * @param numbers the array contains prime numbers between 0-1000
	 */
	public  void columnCount(int number,int[][] numbers) 
	{
		for(int i=0;i<numbers.length;i++) 
		{
			for(int j=0;j<numbers[i].length;j++) 
			{
				if(number!=numbers[i][j] && Integer.toString(number).length() == Integer.toString(numbers[i][j]).length()) 
				{
					boolean flag = Utility.primeAnagramFinder(number,numbers[i][j]);
					if(flag) 
					{
						if(number<100)
							COL1++;
						else if(number<200)
							COL2++;
						else if(number<300)
							COL3++;
						else if(number<400)
							COL4++;
						else if(number<500)
							COL5++;
						else if(number<600)
							COL6++;
						else if(number<700)
							COL7++;
						else if(number<800)
							COL8++;
						else if(number<900)
							COL9++;
						else
							COL10++;
					}
				}
			}
		}
	}
	
	/**
	 * the function stores the prime number that are anagrams in a 
	 * dynamic anagram array.
	 * 
	 * @param number is the prime number between 0-1000 
	 * @param numbers the array to store the prime anagram numbers
	 * @param prime the array contains prime numbers between 0-1000
	 */
	public void storeAnagrams(int number,int[][] numbers,int[][] prime) 
	{
		for(int i=0;i<prime.length;i++) 
		{
			for(int j=0;j<prime[i].length;j++) 
			{
				if(number!=prime[i][j] && Integer.toString(number).length() == Integer.toString(prime[i][j]).length()) 
				{
					boolean flag = Utility.primeAnagramFinder(number,prime[i][j]);
					if(flag) 
					{
						if(number<100)
						{
							numbers[0][COUNT1]=number;
							COUNT1++;
						}
						else if(number<200) 
						{
							numbers[1][COUNT2]=number;
							COUNT2++;
						}
						else if(number<300) 
						{
							numbers[2][COUNT3]=number;
							COUNT3++;
						}
						else if(number<400)
						{
							numbers[3][COUNT4]=number;
							COUNT4++;
						}
						else if(number<500)
						{
							numbers[4][COUNT5]=number;
							COUNT5++;
						}
						else if(number<600)
						{
							numbers[5][COUNT6]=number;
							COUNT6++;
						}
						else if(number<700) {
							numbers[6][COUNT7]=number;
							COUNT7++;
						}
						else if(number<800) {
							numbers[7][COUNT8]=number;
							COUNT8++;
						}
						else if(number<900) {
							numbers[8][COUNT9]=number;
							COUNT9++;
						}
						else {
							numbers[9][COUNT10]=number;
							COUNT10++;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args)
	{
		PrimeAnagramIn2D primeanagram = new PrimeAnagramIn2D();
		//defining the jagged array
		int[][] prime = new int[10][];
				
		//counting the columns of each row of a jagged array
		Utility.columnCountof2DArray(prime);
				
		//storing the prime numbers into 2 D array
		Utility.storePrimes(prime);
				
		//finding the prime anagrams in a particular row
		for(int i=0;i<prime.length;i++) 
		{
			for(int j=0;j<prime[i].length;j++) 
			{
				primeanagram.columnCount(prime[i][j],prime);
			}
			
		}
		//System.out.println(col1+" "+col2+" "+col3+" "+col4+" "+col5);
		//defining the 2D jagged array for anagrams
		int[][] anagrams = new int[10][];
		
		//defining number of anagrams in each row 
		anagrams[0] = new int[COL1];
		anagrams[1] = new int[COL2];
		anagrams[2] = new int[COL3];
		anagrams[3] = new int[COL4];
		anagrams[4] = new int[COL5];
		anagrams[5] = new int[COL6];
		anagrams[6] = new int[COL7];
		anagrams[7] = new int[COL8];
		anagrams[8] = new int[COL9];
		anagrams[9] = new int[COL10];
		
		
		//storing the prime anagram in a dynamic array.
		for(int i=0;i<prime.length;i++) 
		{
			for(int j=0;j<prime[i].length;j++) 
			{
				primeanagram.storeAnagrams(prime[i][j],anagrams,prime);
			}
			
		}
		
		//printing the prime anagram number stored in 2D array
		Utility.jaggedArrayPrint(anagrams, anagrams.length);
		
		
		
		
		
		
		
		
		
		
		
	}

}
