package com.bridgeit.functional;

import java.util.Scanner;

import com.bridgeit.utility.Utility;

public class HarmonicNumber {
	/*
	 *the main function takes N as a input and ensures that is it not equal to 0  
	 */
	public static void main(String[] args) 
	{
		boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		while(flag) 
		{
			System.out.println("Enter the value of N :");
			int N = scanner.nextInt();
			if(N != 0) 
			{
				Utility.harmonicValue(N); 
				flag = false;
			}
			else 
			{
				System.out.println("Please enter the value of N greater than 0 ");
			}
		}

	}

}
