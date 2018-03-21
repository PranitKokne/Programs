/******************************************************************************
 *  
 *
 *  Purpose: Flip fair coin and printing the percentage of Heads and Tails .
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/

package com.bridgeit.functional;

import java.util.Scanner;
import com.bridgeit.utility.Utility;

public class FlipCoin
{
	/*
	 * the static variable is declared so that the user will get another chance if he 
	 * enters a number which is less than 0
	 *
	 */
	static boolean FLAG = true;
	/*
	 *asking the user to how many times he/she wants to flip the coin
	 * and ensuring that it is greater than 0
	 */
	public static void main(String[] args) 
	{
		
		Scanner scanner = new Scanner(System.in);
		while(FLAG) 
		{
			System.out.print("Enter the number of times you want to flip coin :");
			int times = scanner.nextInt();
			if(times>0)
			{
				//using static function of Utility 
				Utility.percentageofHeadsAndTails(times);
				FLAG=false;
			}
		}
		scanner.close();

	}

}
