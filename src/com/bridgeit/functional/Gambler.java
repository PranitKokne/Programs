/******************************************************************************
 *  
 *
 *  Purpose:gambler who start with $stake(cash for each round) and place fair $1 bets 
 *  		until he/she goes broke (i.e. has no money) or reach $goal.
 *   		Keeps track of the number of times he/she wins 
 *   		and the number of bets he/she makes. 
 *   		running the experiment N times, printing the average result.
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/

package com.bridgeit.functional;
import java.util.Scanner;
import java.util.Random;
import com.bridgeit.utility.*;
public class Gambler
{ 
	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the Stake : ");
		int stake = scanner.nextInt();
		
		System.out.print("Enter the Goal you want to reach  : ");
		int goal = scanner.nextInt();
		
		System.out.print("Enter the number of times you want to play : ");
		int noofTimes = scanner.nextInt();
		
		//using the static function of Utility
		Utility.outcome(stake,goal,noofTimes);
	}

}
