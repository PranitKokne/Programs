package com.bridgeit.algorithm;
import java.util.Scanner;

import com.bridgeit.utility.Utility;
public class FindNumber
{
	public static int binarySearch(int[] sort, int n,int fe) 
	{
		int start = 0;
		int end = n-1;
		while(start<=end) 
		{
			int mid = (start+end)/2;
			if(sort[mid]==fe) 
			{
				return mid;
			}
			else if(sort[mid]>fe) 
			{
				end = mid -1;
			}
			else 
			{
				start = mid+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) 
	{
		int n=0;
		int[] powerofTwo = {1,2,4,8,16,32,64,128,512};
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number which is a power of 2 : ");
		int size = scanner.nextInt();
		
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
		int secreatNumber = scanner.nextInt();
		
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
			boolean lresponse = scanner.nextBoolean();
			System.out.println("your number is between "+(middle1+1)+" and "+last);
			boolean rresponse = scanner.nextBoolean();
			if(lresponse) 
			{
				first=first;
				last=middle1;
				middle1=Utility.midCalculator(first,last);
			}
			else 
			{
				first=middle1+1;
				last=last;
				middle1=Utility.midCalculator(first,last);
			}
			n--;
		}
		System.out.println("is this your number : "+binarySearch(numbers,numbers.length,secreatNumber));
	}

}
