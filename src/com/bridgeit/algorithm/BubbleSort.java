/******************************************************************************
 *  
 *
 *  Purpose:the program print the sorted Integer array using bubble 
 *  		sort algorithm.
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/

package com.bridgeit.algorithm;

import java.util.Scanner;
import com.bridgeit.utility.Utility;

public class BubbleSort
{
	/*
	 * the main function takes the size of an Integer array
	 * and the elements of it as a input and print the 
	 * unsorted array.
	 * 
	 */
	public static void main(String[] args) 
	{
		Utility util = new Utility();
		System.out.print("Enter the size of an array : ");
		int size = util.integerInput();
		
		Integer[] numbers = new Integer[size];
		
		System.out.println("Enter "+size+" elements into array :");
		for(int i=0;i<numbers.length;i++) 
		{
			numbers[i]=util.integerInput();
		}
		
		System.out.println("array before sorting :");
		for(Integer ele : numbers) 
		{
			System.out.print(ele+" ");
		}
		
		System.out.println("\narray after sorting : ");
		//using static function of Utility
		Utility.bubbleSort(numbers,size);
		
		
	}

}
