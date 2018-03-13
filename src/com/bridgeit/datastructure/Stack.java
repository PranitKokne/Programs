/**
 * Purpose :The program takes arithmetic expression as a input such as
 * 			(5+6)∗(7+8) and ensure it's parentheses are balanced or not
 * 			
 * 
 * @author Pranit_Kokne
 * @version 1.0
 * @since 07-03-2018
 *
 */

package com.bridgeit.datastructure;

import com.bridgeit.utility.Utility;

public class Stack 
{ 
	/**
	 * main function takes an arithmetic expression as a input
	 * convert it to the char array and ensure that the parentheses
	 * are balanced or not. 
	 */
	public static void main(String[] args)
	{
		int size=0;
		
		Utility util = new Utility();
		//taking the expression from user
		System.out.println("Enter the arithmetic expression : ");
		String arithmeticExpression = util.inputStringLine();
		
		//storing it into an character array
		char[] expression = Utility.intoCharArray(arithmeticExpression);
		
		//calculating the size of stack
		for(int i=0;i<expression.length;i++) 
		{
			if(expression[i]=='(') 
			{
				size++;
			}
		}
		
		//creating stack for push and pop operation
		char[] stack = new char[size];
		int top = -1;
		
		//checking the result
		int position = Utility.stackOperation(stack,top,expression);
		
		if(position==-1) 
		{
			System.out.println("The arithmetic expression is balanced.");
		}
		else 
		{
			System.out.println("The arithmetic expression is not balanced.");
		}


	}

}
