/******************************************************************************
 *  
 *
 *  Purpose:the program print the sorted String array using insertion 
 *  		sort algorithm. .
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/

package com.bridgeit.algorithm;

import java.util.Scanner;

import com.bridgeit.utility.Utility;

public class InsertionSort {
	/*
	 * the main function takes the size of an String array
	 * and the elements of it as a input and print the 
	 * unsorted array.
	 */
	public static void main(String[] args) 
	{
		Utility util = new Utility();
		System.out.print("Enter the size of an array : ");
		int size = util.integerInput();
		
		String[] names = new String[size];
		
		System.out.println("Enter "+size+" elements into array :");
		for(int i=0;i<names.length;i++) 
		{
			names[i]=util.inputString();
		}
		
		System.out.println("array before sorting :");
		for(String ele : names) 
		{
			System.out.print(ele+" ");
		}
		
		System.out.println("\narray after sorting : ");
		//using static function of Utility
		Utility.insertionSorting(names,size);

	}

}
