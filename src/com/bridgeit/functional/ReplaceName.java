/******************************************************************************
 *  
 *
 *  Purpose: Replacing the String template <<UserName>> with proper name.
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/

package com.bridgeit.functional;

import java.util.Scanner;
import com.bridgeit.utility.Utility;

public class ReplaceName 
{
	/*
	 * The main function is written to replace the <<UserName>> with the proper name
	 */
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		while(true)
		{
			//taking the proper name from user as a input
			System.out.println("Enter Your Name : ");
			String username = scanner.nextLine();
			//checking user name contains atleast 3 character or not
			if(username.length()>=3)
			{
				//using static function of Utility 
				Utility.displayName(username);
				break;
			}
			else
			{
				System.out.println("Please Enter a name with atleast 3 character");
			}
		}

	}

}
