
package com.bridgeit.datastructure;

import com.bridgeit.utility.Utility;

public class PrimeNumbers {

	public static void main(String[] args) 
	{
		int[][] prime = new int[10][100];
		
		int j = 0;
		int num = 100;
		int column = 0;
		
		for(int i=0;i<10;i++) 
		{
			for(;j<num;j++) 
			{
				if(j>=2) 
				{
					int primeNumber = Utility.findPrime(j);
					if(primeNumber>1) 
					{
						/*prime[i][column]=j;
						column++;*/
						System.out.print(primeNumber+" ");
					}
				}
			}
			j=num;
			num+=100;
			column=0;
			System.out.println();
		}
		//printing the prime number stored in 2D array
		
		/*for(int q=0;q<prime.length;q++) 
		{
			for(int p=0;p<prime[q].length;p++) 
			{
				System.out.print(prime[q][p]+" ");
			}
			System.out.println();
		}
*/		
		
	}

}
