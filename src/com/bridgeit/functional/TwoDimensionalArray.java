/******************************************************************************
 *  
 *
 *  Purpose:declaring creating and reassigning the values 
 *  		of two dimensional array of Integer,Double or Boolean
 *  		and printing the two dimensional array to console.
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/
package com.bridgeit.functional;

import java.util.Scanner;
import com.bridgeit.utility.Utility;

public class TwoDimensionalArray
{
	/*
	 * the main function takes the type of array its length
	 * and then the number of elements from user.
	 */
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press 1 for integer array");
		System.out.println("Press 2 for double array");
		System.out.println("Press 3 for boolean array");
		System.out.println("Press any key to  exit");

		while(true) 
		{
			System.out.print("Enter your choice : ");
			int choice = scanner.nextInt();
			System.out.print("Enter number of rows : ");
			int rows = scanner.nextInt();
			System.out.print("Enter number of columns : ");
			int cols = scanner.nextInt();
			
			switch(choice) 
			{
			case 1 :
				Integer[][] intarray = new Integer[rows][cols];
				for(int i=0;i<rows;i++) 
				{
					System.out.println("Enter the elements of "+(i+1)+" row ");
					for(int j=0;j<rows;j++) 
					{
						intarray[i][j]=scanner.nextInt();
					}
				}
				//using the static function of Utility
				Utility.printTwoDimensionalArray(intarray);
				break;
				
			case 2 :
				Double[][] doublearray = new Double[rows][cols];
				for(int i=0;i<rows;i++) 
				{
					System.out.println("Enter the elements of "+(i+1)+" row ");
					for(int j=0;j<rows;j++) 
					{
						doublearray[i][j]=scanner.nextDouble();
					}
				}
				//using the static function of Utility
				Utility.printTwoDimensionalArray(doublearray);
				break;
				
			case 3 :
				Boolean[][] booleanarray = new Boolean[rows][cols];
				for(int i=0;i<rows;i++) 
				{
					System.out.println("Enter the elements of "+(i+1)+" row ");
					for(int j=0;j<rows;j++) 
					{
						booleanarray[i][j]=scanner.nextBoolean();
					}
				}
				//using the static function of Utility
				Utility.printTwoDimensionalArray(booleanarray);
				break;
				
			default :
					System.exit(0);
			
			}
			
					
		}
	}

}
