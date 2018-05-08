/******************************************************************************
 *  
 *
 *  Purpose:the program sort the list containing the string object by using
 *  		the merge sort algorithm.
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/

package com.bridgeit.algorithm;

import com.bridgeit.utility.*;

public class MergeSortString 
{
	/*
	 * the main function takes the size of an array and 
	 * the string objects as a input from user and print 
	 * the sorted string array
	 */
	public static void main(String[] args) 
	{
		Utility util = new Utility();
		System.out.print("Enter the size of an array : ");
		int size = util.integerInput();
		
		//consumer string
		util.inputStringLine();
		
		String[] array = new String[size];
		
		//accepting input from user
		System.out.println("Enter "+size+" string elements : ");
		for(int i=0;i<array.length;i++) 
		{
			array[i]=util.inputStringLine();
		}
		//using the static method of Utility
		Utility.divideMerge(array,array.length);
		for(String ele:array) 
		{
			System.out.print(ele+" ");
		}
	}
}
