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
		Utility util = new Utility();
		
		Long[] time = new Long[6];
		String[] sorting = {"Binary Search Integer","Binary Search String","Insertion Sort Integer","Insertion Sort String","Bubble Sort Integer","Bubble Sort String"};
		
		long startTime = 0;
		long stopTime = 0;
		long elapsedTime = 0;
		
		System.out.println("Press 1 for binarySearch method for integer");
		System.out.println("Press 2 for binarySearch method for String");
		System.out.println("Press 3 for insertionSort method for integer");
		System.out.println("Press 4 for insertionSort method for String");
		System.out.println("Press 5 for bubbleSort method for integer");
		System.out.println("Press 6 for bubbleSort method for String");
		System.out.println("Press any key to exit");
		
		boolean flag = true;
		
		while(flag) 
		{
			System.out.print("Enter your choice :");
			int choice = util.integerInput();
		
			Integer[] numbers = {99,25,110,54,10,5};			
			String[] names = {"pranit","kokne","anita","eknath","prajakta"};

			switch(choice) 
			{
				
			case 1:
				startTime=System.nanoTime();
				int[] intarray = {10,20,30,40,50};
				output = Utility.binarySearch(intarray, intarray.length, 10);
				if(output>=0) 
				{
					System.out.println("The element is present at "+output+ " index position.");
				}
				stopTime=System.nanoTime();
				elapsedTime=stopTime-startTime;
				//System.out.println("binary search integer : "+elapsedTime);
				time[choice-1]=elapsedTime;
				break;
				
				
			case 2:
				startTime=System.nanoTime();
				String[] stringarray1 = {"aashish","balaji","champion","disco","epic"};			
				output=Utility.binarySearchForString(stringarray1,stringarray1.length, "epic");
				if(output>=0) 
				{
					System.out.println("The element is present at "+output+" index position.");
				}
				stopTime=System.nanoTime();
				elapsedTime=stopTime-startTime;
				//System.out.println("binary search String : "+elapsedTime);
				time[choice-1]=elapsedTime;
				break;
				
				
			case 3:
				startTime=System.nanoTime();
				Utility.insertionSorting(numbers,numbers.length);
				stopTime=System.nanoTime();
				elapsedTime=stopTime-startTime;
				//System.out.println("insertion sort integer : "+elapsedTime);
				time[choice-1]=elapsedTime;
				break;
				
				
			case 4:
				startTime=System.nanoTime();
				Utility.insertionSorting(names,names.length);
				stopTime=System.nanoTime();
				elapsedTime=stopTime-startTime;
				//System.out.println("insertion sort String : "+elapsedTime);
				time[choice-1]=elapsedTime;
				break;
				
				
			case 5:
				startTime=System.nanoTime();
				Utility.bubbleSort(numbers, numbers.length);
				stopTime=System.nanoTime();
				elapsedTime=stopTime-startTime;
				//System.out.println("bubble sort integer : "+elapsedTime);
				time[choice-1]=elapsedTime;
				break;
				
				
			case 6:
				startTime=System.nanoTime();				
				Utility.bubbleSort(names, names.length);
				stopTime=System.nanoTime();
				elapsedTime=stopTime-startTime;
				//System.out.println("bubble sort String : "+elapsedTime);
				time[choice-1]=elapsedTime;
				break;
				
			default:
				Long[] sortTime = time;
				Utility.bubbleSort(sortTime,sortTime.length);
				for(int i=sortTime.length-1;i>=0;i--) 
				{
					for(int j=0;j<time.length;j++) 
					{
						if(sortTime[i] == time[j]) 
						{
							System.out.println("Elapsed time for "+sorting[j]+" : "+sortTime[i]+" nanoseconds");
						}
					}
				}
				flag = false;
				System.exit(0);
			}

		}
		
	}
	

}
