/**
 * Purpose :The program asks the user to enter a number which is power of two
 * 			then he asks the user to keep one number in mind(between 0 to powerOfTwo-1).
 * 			and after the n iteration finds the number
 * 
 * @author Pranit_Kokne
 *@version 1.0
 *@since 05-03-2018
 */

package com.bridgeit.algorithm;

import com.bridgeit.utility.Utility;

public class FindNumber
{
	public static void main(String[] args) 
	{
		int n=0;
		int[] powerofTwo = {1,2,4,8,16,32,64,128,512};
		Utility util = new Utility();
		System.out.print("Enter a number which is a power of 2 : ");
		int size = util.integerInput();
		
		int[] numbers = new int[size];
		
		for(int i=0;i<size;i++) 
		{
			numbers[i]=i;
		}
		for(int ele:numbers) 
		{
			System.out.print(ele+" ");
		}
		System.out.println("\nChoose a number between 0 and "+(size-1));
		int secreatNumber = util.integerInput();
		
		//finding the value of n 
		for(int i=0;i<powerofTwo.length;i++) 
		{
			if(powerofTwo[i]==size) 
			{
				n=i;
			}
		}
		int first = 0;
		int last = size-1;
		int middle1 = (first+last)/2;
		
		while(n>1) 
		{
			System.out.println("your number is between "+first+" and "+middle1);
			boolean lresponse = util.booleanInput();
			System.out.println("your number is between "+(middle1+1)+" and "+last);
			boolean rresponse = util.booleanInput();
			if(lresponse) 
			{
				last=middle1;
				middle1=Utility.midCalculator(first,last);
			}
			else if(rresponse)
			{
				first=middle1+1;
				middle1=Utility.midCalculator(first,last);
			}
			n--;
		}
		System.out.println("is this your number : "+Utility.binarySearch(numbers,numbers.length,secreatNumber));
	}

}
