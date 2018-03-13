/**
 * Purpose :The program finds the number of different binary search trees
 * 			that can be constructed based on the number of nodes.
 * 			
 * 
 * @author Pranit_Kokne
 * @version 1.0
 * @since 13-03-2018
 *
 */

package com.bridgeit.datastructure;

import com.bridgeit.utility.Utility;

public class BinarySearchTree {

	/**
	 *main function takes the number of test cases and the number of nodes as a input
	 *from user and generate the different binary search trees.
	 */
	public static void main(String[] args) {
		Utility util = new Utility();
		int testCaseCount = 1;
		
	 
		
			System.out.print("Enter the number of Test Cases : ");
			int testCases = util.integerInput();
			
			if(testCases>=1 && testCases<=1000) 
			{
				while(testCaseCount<=testCases) 
				{
					System.out.println("Test Case "+testCaseCount);
					System.out.print("Enter the number of nodes in binary search tree : ");
					double nodes = util.doubleInput();
					
					if(nodes<=1000 && nodes>=1)
					{
						double binaryTrees = Utility.binarySearchTrees(nodes);
						System.out.println("The number of different binary search trees that can be created using "+nodes+" nodes are : "+binaryTrees);
						testCaseCount++;
					}
					else 
					{
						System.out.println("Enter the nodes value between 0 to 1000");
					}
				}
			}
			else 
			{
				System.out.println("Enter the value of Test Cases between 0 and 1000");
			}
			
			
		}

}
