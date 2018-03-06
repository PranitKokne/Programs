/******************************************************************************
 *  
 *
 *  Purpose:The program performs the binary search,insertion sort and bubble sort
 *  		on integer and strings.
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/

package com.bridgeit.algorithm;

import java.util.Scanner;
import com.bridgeit.utility.Utility;

public class Example3 
{
	/*
	 * main function takes the type of array its size as a input and perform
	 * sorting or searching based on the user requirement.
	 * it also measure the time taken by an individual algorithm and prints
	 * the time in descending order.
	 * 
	 */
	public static void main(String[] args) 
	{
		int output;
		
		Scanner scanner = new Scanner(System.in);
		
		Long[] time = new Long[6];
		
		long startTime = 0;
		long stopTime = 0;
		long elapsedTime = 0;
		
		System.out.println("Press 1 for binarySearch method for integer");
		System.out.println("Press 2 for binarySearch method for String");
		System.out.println("Press 3 for insertionSort method for integer");
		System.out.println("Press 4 for insertionSort method for String");
		System.out.println("Press 5 for bubbleSort method for integer");
		System.out.println("Press 6 for bubbleSort method for String");
		
		boolean flag = true;
		
		while(flag) 
		{
			System.out.print("Enter your choice :");
			int i = scanner.nextInt();
			
			System.out.print("Enter the size of an array :");
			int size = scanner.nextInt();
			
			
				Integer[] numbers = new Integer[size];
			
			
			String[] names = new String[size];
			
		
			switch(i) 
			{
				
			case 1:
				int[] intarray = new int[size];
				startTime=System.currentTimeMillis();
				System.out.println("Enter the "+size+" integer elements");
				for(int j=0;j<size;j++) 
				{
					intarray[j]=scanner.nextInt();
				}
				System.out.print("Enter the element you want to search :");
				int search = scanner.nextInt();
				
				output = Utility.binarySearch(intarray, intarray.length, search);
				if(output>=0) 
				{
					System.out.println("The element is present at "+output+ " index position.");
				}
				stopTime=System.currentTimeMillis();
				elapsedTime=stopTime-startTime;
				System.out.println("binary search integer : "+elapsedTime);
				time[i-1]=elapsedTime;
				break;
				
				
			case 2:
				String[] stringarray1 = new String[size];
				startTime=System.currentTimeMillis();
				System.out.println("Enter the "+size+" string elements");
				for(int j=0;j<size;j++) 
				{
					stringarray1[j]=scanner.next();
				}
				System.out.print("Enter the element you want to search :");
				String element = scanner.next();
				
				output=Utility.binarySearchForString(stringarray1,stringarray1.length, element);
				if(output>=0) 
				{
					System.out.println("The element is present at "+output+" index position.");
				}
				stopTime=System.currentTimeMillis();
				elapsedTime=stopTime-startTime;
				System.out.println("binary search String : "+elapsedTime);
				time[i-1]=elapsedTime;
				break;
				
				
			case 3:
				
				startTime=System.currentTimeMillis();
				System.out.println("Enter the "+size+" integer elements");
				for(int j=0;j<size;j++) 
				{
					numbers[j]=scanner.nextInt();
				}
				
				Utility.insertionSorting(numbers,numbers.length);
				stopTime=System.currentTimeMillis();
				elapsedTime=stopTime-startTime;
				System.out.println("insertion sort integer : "+elapsedTime);
				time[i-1]=elapsedTime;
				break;
				
				
			case 4:
				
				startTime=System.currentTimeMillis();
				System.out.println("Enter the "+size+" string elements");
				for(int j=0;j<size;j++) 
				{
					names[j]=scanner.next();
				}
				
				Utility.insertionSorting(names,names.length);
				stopTime=System.currentTimeMillis();
				elapsedTime=stopTime-startTime;
				System.out.println("insertion sort String : "+elapsedTime);
				time[i-1]=elapsedTime;
				break;
				
				
			case 5:
				
				startTime=System.currentTimeMillis();
				System.out.println("Enter the "+size+" integer elements");
				for(int j=0;j<size;j++) 
				{
					numbers[j]=scanner.nextInt();
				}
				
				Utility.bubbleSort(numbers, numbers.length);
				stopTime=System.currentTimeMillis();
				elapsedTime=stopTime-startTime;
				System.out.println("bubble sort integer : "+elapsedTime);
				time[i-1]=elapsedTime;
				break;
				
				
			case 6:
				
				startTime=System.currentTimeMillis();
				System.out.println("Enter the "+size+" string elements");
				for(int j=0;j<size;j++) 
				{
					names[j]=scanner.next();
				}
				
				Utility.bubbleSort(names, names.length);
				stopTime=System.currentTimeMillis();
				elapsedTime=stopTime-startTime;
				System.out.println("bubble sort String : "+elapsedTime);
				time[i-1]=elapsedTime;
				break;
				
				
			default:
				flag=false;
			}
		}
		
		Utility.bubbleSort(time,time.length);
		for(int i=time.length-1;i>=0;i--) 
		{
			System.out.print(time[i]+" ");
		}
	}
	

}
