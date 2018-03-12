package com.bridgeit.datastructure;

import java.util.ArrayList;

import com.bridgeit.utility.Utility;

public class PrimeAnagramIn2D 
{
	static int count12 = 0;
	static int col1=0;   static int col6=0;						 
	static int col2=0;   static int col7=0;
	static int col3=0;	 static int col8=0;
	static int col4=0;	 static int col9=0;
	static int col5=0;   static int col10=0;
	
	static int count1 = 0;	static int count2 = 0;
	static int count3 = 0;	static int count4 = 0;
	static int count5 = 0;	static int count6 = 0;
	static int count7 = 0;	static int count8 = 0;
	static int count9 = 0;	static int count10 = 0;
	
	
	
	public  void columnCount(int number,int[][] numbers) 
	{
		for(int i=0;i<numbers.length;i++) 
		{
			for(int j=0;j<numbers[i].length;j++) 
			{
				if(number!=numbers[i][j] && Integer.toString(number).length() == Integer.toString(numbers[i][j]).length()) 
				{
					boolean flag = Utility.primeAnagramFinder(number,numbers[i][j]);
					if(flag) 
					{
						if(number<100)
							col1++;
						else if(number<200)
							col2++;
						else if(number<300)
							col3++;
						else if(number<400)
							col4++;
						else if(number<500)
							col5++;
						else if(number<600)
							col6++;
						else if(number<700)
							col7++;
						else if(number<800)
							col8++;
						else if(number<900)
							col9++;
						else
							col10++;
					}
				}
			}
		}
	}
	
	public void storeAnagrams(int number,int[][] numbers,int[][] prime) 
	{
		for(int i=0;i<prime.length;i++) 
		{
			for(int j=0;j<prime[i].length;j++) 
			{
				if(number!=prime[i][j] && Integer.toString(number).length() == Integer.toString(prime[i][j]).length()) 
				{
					boolean flag = Utility.primeAnagramFinder(number,prime[i][j]);
					if(flag) 
					{
						if(number<100)
						{
							numbers[0][count1]=number;
							count1++;
						}
						else if(number<200) 
						{
							numbers[1][count2]=number;
							count2++;
						}
						else if(number<300) 
						{
							numbers[2][count3]=number;
							count3++;
						}
						else if(number<400)
						{
							numbers[3][count4]=number;
							count4++;
						}
						else if(number<500)
						{
							numbers[4][count5]=number;
							count5++;
						}
						else if(number<600)
						{
							numbers[5][count6]=number;
							count6++;
						}
						else if(number<700) {
							numbers[6][count7]=number;
							count7++;
						}
						else if(number<800) {
							numbers[7][count8]=number;
							count8++;
						}
						else if(number<900) {
							numbers[8][count9]=number;
							count9++;
						}
						else {
							numbers[9][count10]=number;
							count10++;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args)
	{
		PrimeAnagramIn2D primeanagram = new PrimeAnagramIn2D();
		//defining the jagged array
		int[][] prime = new int[10][];
				
		//counting the columns of each row of a jagged array
		Utility.columnCountof2DArray(prime);
				
		//storing the prime numbers into 2 D array
		Utility.storePrimes(prime);
				
		
		
		//System.out.println();
		
		for(int i=0;i<prime.length;i++) 
		{
			for(int j=0;j<prime[i].length;j++) 
			{
				primeanagram.columnCount(prime[i][j],prime);
			}
			
		}
		//System.out.println(col1+" "+col2+" "+col3+" "+col4+" "+col5);
		//defining the 2D jagged array for anagrams
		int[][] anagrams = new int[10][];
		
		//defining number of anagrams in each row 
		anagrams[0] = new int[col1];
		anagrams[1] = new int[col2];
		anagrams[2] = new int[col3];
		anagrams[3] = new int[col4];
		anagrams[4] = new int[col5];
		anagrams[5] = new int[col6];
		anagrams[6] = new int[col7];
		anagrams[7] = new int[col8];
		anagrams[8] = new int[col9];
		anagrams[9] = new int[col10];

		for(int i=0;i<prime.length;i++) 
		{
			for(int j=0;j<prime[i].length;j++) 
			{
				primeanagram.storeAnagrams(prime[i][j],anagrams,prime);
			}
			
		}
		
		//printing the prime number stored in 2D array
		Utility.jaggedArrayPrint(anagrams, anagrams.length);
		
		System.out.println();
		//storing the prime numbers between 0-1000 in a list
		
		ArrayList<Integer> primenum = new ArrayList<Integer>();
		
		//adding prime numbers from 0 to 1000 in an list
		for(int i=0;i<=1000;i++)
		{
			//using the static function of Utility
			int prime1 = Utility.findPrime(i);
			if(prime1>0) 
			{
				primenum.add(i);
			}
		}
		
		System.out.println(primenum);
		
		//defining non anagram array
		int[][] nonanagram = new int[10][25];
		
		/*int listcount = 0;
		int row = 0;
		int column = 0;
		for(int i=0;i<anagrams.length;i++) 
		{
			for(int j=0;j<anagrams[i].length;j++) 
			{
				if(primenum.get(listcount) != anagrams[i][j]) 
				{
					nonanagram[row][column]=primenum.get(listcount);
					column++;
				}
				listcount++;
			}
			row++;
		}
		
		for(int i=0;i<10;i++) 
		{
			for(int j=0;j<25;j++)
			{
				if(nonanagram[i][j]!=0)
					System.out.print(nonanagram[i][j]+" ");
			}
		}*/
		
		
	}

}
