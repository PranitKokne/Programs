package com.bridgeit.utility;

import java.io.PrintWriter;
import java.util.Scanner;

import com.bridgeit.datastructure.Customer;
import com.bridgeit.datastructure.Queue;

public class Utility 
{
	
	public  Scanner takeInput() 
	{
		Scanner scanner = new Scanner(System.in);
		return scanner;
	}
	
	/*
	 * functional programs
	 * 
	 */
	
	/**
	    * Function to replace the <<UserName>> with proper name
	    * 
	    * @param sample the sample is used to store the predefined String
	    * @param name the name is used to print the String with proper name
	    */
	public static void displayName(String username)
	{
		String sample = "Hello <<UserName>>, How are you?";
		String name = sample.replaceFirst("<<UserName>>",username);
		System.out.println(name);
	}
	
	/**
	 *Function Prints the percentage of Heads and Tails
	 * 
	 * @param noofHeads to count the number of Heads
	 * @param percentageofHeads to store the percentage of Heads
	 * @param percentageofTails to store the percentage of Tails 
	 */
	
	public static void percentageofHeadsAndTails(int times) 
	{
		double noofHeads = 0;
		
		for(int i=0;i<times;i++) 
		{
			if(Math.random()<0.5) 
			{
				noofHeads++;
			}
		}
		
		//calculating % of heads and tails
		double percentageofHeads=((noofHeads/times)*100);
		double percentageofTails=(100-percentageofHeads);
		
		//printing the percentage of heads and tails
		System.out.println("The percentage of heads : "+percentageofHeads);
		System.out.println("The percentage of Tails : "+percentageofTails);
	}
	/**
	 * function determines the entered year is a leap year or not
	 * and printing the result according to it
	 * 
	 *@param year the year is entered by the user to check if it is leap year or not
	 */
	public static void checkLeapYear(int year) 
	{
		if(year%100==0) 
		{
			if(year%400==0) 
			{
				System.out.println("The entered centurion year "+year+" is a leap year...");
			}
			else 
			{
				System.out.println("The entered centurion year "+year+" is not a leap year...");
			}
		}
		else 
		{
			if(year%4==0) 
			{
				System.out.println("The entered year "+year+" is a leap year...");
			}
			else 
			{
				System.out.println("The entered year "+year+" is not a leap year...");
			}
		}
	
	}
	
	
	/**
	 * function taking n as a input and prints a table of the powers of 2  
	 * that are less than or equal to 2^n.
	 * 
	 * @param result the result holds the value of each row of a 
	 * table
	 */
	public static void Table(int n)
	{
		for(int i=0;i<=n;i++)
		{
			int result =(int)Math.pow(2,i);			
			System.out.println(result);
		}
	}
	
	/**
	 * function print the Nth harmonic value
	 * 
	 * @param total the total holds harmonic value
	 */
	public static void harmonicValue(int N) 
	{
		double total=0.0;
		for(double i=1;i<=N;i++)
		{
			double div = 1/i;
			total+=div;
		}
		System.out.println(N+"th harmonic value :"+total);
	}
	
	/**
	 *checking the provided number is prime or not
	 *if prime return the number 
	 *else return the -1 indicating it is not a prime number 
	 * 
	 * 
	 */
	public static int findPrime(int number) 
	{
		for(int i=2;i<number;i++) 
		{
			if(number%i==0)
			{
				return -1;
			}
		}
		return number;
	}
	/**
	 * the outcome function checks whether the gambler
	 * is reaching his goal or going broke after playing n times
	 * and based on the result printing the percentage of win 
	 * and percentage of loss and number of times the gambler won the game out of n.
	 * 
	 * @param win the win to count the number of wins
	 * @param Stake the stake means the cash the gambler is using per round
	 * 
	 */
	public static void outcome(int stake,int goal,int noofTimes) 
	{
		float win = 0;
		int broke = 0;
		for(int i=0;i<noofTimes;i++)
		{
			int Stake=stake;
			boolean flag = true;
			while(flag) 
			{
				double no = Math.random();
				if(no<0.5) 
				{
					Stake++;
					if(Stake==goal) 
					{
						win++;
						System.out.println("Congratulations..! You won the game.");
						System.out.println("You reached your goal of "+goal+"\n");
						flag=false;
					}
				}
				else 
				{
					Stake--;
					if(Stake==broke) 
					{
						System.out.println("Unfortunalitly you lost the game.");
						System.out.println("your stake is "+broke+"\n");
						flag = false;
					}
				}
			}
			System.out.println("stake : "+Stake);
			System.out.println("goal : "+goal);
		}
		System.out.println(win);
		
		//calculating winnig and losing percentage
		float winningPercentage = (win/noofTimes)*100;
		float lossingPercentage = 100-winningPercentage;
		
		//printing the winning and lossing percentage
		System.out.println("Winning percentage : "+winningPercentage);
		System.out.println("Losing percentage : "+lossingPercentage);
		
	}

	/**
	 * function prints the two dimensional array using PrintWriter class 
	 * 
	 */
	public static void printTwoDimensionalArray(Object[][] object) 
	{
		for(int i=0;i<object.length;i++)
		{
			for(int j=0;j<object.length;j++) 
			{
				PrintWriter out = new PrintWriter(System.out);
				out.print(object[i][j]+" ");
				out.flush();
			}
			System.out.println();
		}
	}
	
	/**
	 * function prints the distinct triplets that exactly sum to 0
	 * 
	 * @param distinctTriplets the distinctTriplets counts the number of distinct triplets
	 */
	public static void sumEqualToZero(int[] number)
	{
		int distinctTriplets = 0;
		for(int i=0;i<number.length;i++) 
		{
			for(int j=i+1;j<number.length;j++) 
			{
				for(int k=j+1;k<number.length;k++) 
				{
					if(number[i]+number[j]+number[k]==0) 
					{
						System.out.println("The Distinct Triplet : "+number[i]+" "+number[j]+" "+number[k]);
						distinctTriplets++;
					}
				}
			}
		}
		System.out.println("Number of distinct Triplets : "+distinctTriplets);	
	}
	
	/**
	 * function prints the eculidean distance from (x,y) to (0,0)
	 * 
	 * @param xRaiseToX to store the x raise to x value
	 * @param yRaiseToY to store the y raise to y value
	 * @param sum to store the sum of x^x and y^y
	 */
	public static void euclideanDistance(int x,int y) 
	{
		//finding the power of x and y
		double xRaiseToX = Math.pow(x,x);
		double yRaiseToY = Math.pow(y,y);
		double sum = xRaiseToX + yRaiseToY;
		
		//finding the euclidean distance
		double euclideanDistance = Math.sqrt(sum);
		
		//printing the distance 
		System.out.print("The euclidean distance from the point ("+x+","+y+") to the origin (0, 0) : "+euclideanDistance);
	}
	
	/**
	 * function acts as a stop watch when user press 1 the stop watch starts 
	 * and when user press 2 the stop watch stops.
	 * at the end the elapsed time is calculated and printed to the console.
	 */
	public static void watch() 
	{
		long startTime=0l;
		long stopTime=0l;
		boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("Press 1 to start the stop watch :");
			int start = scanner.nextInt();
			if(start==1) 
			{
				startTime = System.currentTimeMillis();
				System.out.println("start time : "+startTime);
				System.out.println("stop watch started :  ");
				boolean flag2 = true;
				while(flag2) 
				{
					System.out.print("Press 2 To stop the watch : ");
					int stop=scanner.nextInt();
					
					
					if(stop==2) 
					{
						stopTime = System.currentTimeMillis();
						System.out.println("stop time : "+stopTime);
						flag2=false;
					}
					
				}
				System.out.println("Elapsed time : "+(stopTime-startTime)+" ms");
				flag=false;
			}
			
		}

	}
	
	/**
	 * function finds the roots of the quadratic equation 
	 * using general formula and prints the two roots in 
	 * the console
	 * 
	 * @param root1 is the first root of the quadratic equation
	 * @param root2 is the second root of the quadratic equation
	 */
	public static void roots(int a,int b,int c) 
	{
		
		double delta = ((b*b)-(4*a*c));
		double root1 = (-b + Math.sqrt(delta))/(2*a);
		double root2 = (-b - Math.sqrt(delta))/(2*a);
		 
		System.out.println("root1 of x = "+root1);
		System.out.println("root2 of x = "+root2);
	}
	
	/**
	 *function calculates the wind chill using general formula and later print it.
	 *
	 * @param windchill the windchill holds the result of mathematical operation
	 * 
	 */
	public static void windChillCalculator(double t,double v) 
	{
		double windchill = 0.0;
		windchill = 35.74+(0.6215*(t))+((0.4275*t-35.75)*(Math.pow(v,0.16)));
		System.out.println("Wind Chill : "+windchill+"  Fahrenheit");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//////////////////////////
	/*
	 * algorithm programs
	 * 
	 */
	
	/**
	 * function ensure that the two strings are anagram 
	 * or not and print the result according to it.
	 * 
	 * @param array1 to store the char conversion of first string
	 * @param array3 is initially an empty char array
	 * @param word3 is the string conversion of character array
	 * 
	 */
	public static void checkAnagram(String word1,String word2) 
	{
		
		char[] array1 = word1.toCharArray();
		char[] array3 = new char[word2.length()];
		
		for(int i=0;i<word2.length();i++) 
		{
			for(int j=0;j<array1.length;j++) 
			{
				if(word2.charAt(i)==array1[j]) 
				{
					array3[j]=word2.charAt(i);
				}
			}
		}
		
		String word3 = new String(array3);
		//System.out.println(word3);
		if(word1.equalsIgnoreCase(word3)) 
		{
			System.out.println(word1+" and "+word2+" are anagram..!");
		}
		else 
		{
			System.out.println(word1+" and "+word2+" are not anagram..!");
		}
	}
	
	/**
	 * sorts the character array using bubble sort algorithm
	 * 
	 */
	
	public static void bubbleSorting(char[] arr,int n) 
	{
		char temp;
		for(int j=0;j<=n-2;j++) 
		{
			for(int i=0;i<=n-2;i++) 
			{
				if(arr[i]>arr[i+1]) 
				{
					temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
				}
			}
		}
	}
	
	/**
	 * function find the prime number is palindrome or not 
	 *  
	 *@return true if the prime number is palindrome else return 
	 *false 
	 */
			public static boolean primePalindromeFinder(int primeNumber) 
			{
				String temp = "";
				String original = temp+primeNumber;
				//System.out.println(original);
				
				String empty = "";
				for(int j=original.length()-1;j>=0;j--) 
				{
					empty=empty+original.charAt(j);
				}
				
				if(empty.equals(original)) 
				{
					return true;
				}	
				return false;
			}
			/**
			 *function find the prime number is anagram or not
			 *
			 *@return true if anagram else return false 
			 */
			
			public static boolean primeAnagramFinder(int num1,int num2) 
			{
				//converting numbers into string
				String number1 = Integer.toString(num1);
				String number2 = Integer.toString(num2);
				
				//converting into char array
				char[] firstno = number1.toCharArray();
				char[] secondno = number2.toCharArray();
				
				//sorting
				bubbleSorting(firstno,firstno.length);
				bubbleSorting(secondno,secondno.length);
				
				int count=firstno.length;
				for(int i=0,j=0;i<firstno.length;i++,j++) 
				{
					if(firstno[i]-secondno[j]==0) 
					{
						count--;
					}
				}
				if(count==0) 
				{
					return true;
				}
				return false;
			}
	/**
	 * function performs the binary search operation on integer array
	 */
			public static int binarySearch(int[] sort, int n,int fe) 
			{
				int start = 0;
				int end = n-1;
				while(start<=end) 
				{
					int mid = (start+end)/2;
					if(sort[mid]==fe) 
					{
						return mid;
					}
					else if(sort[mid]>fe) 
					{
						end = mid -1;
					}
					else 
					{
						start = mid+1;
					}
				}
				return -1;
			}
	/**
	 * function performs the binary search operation on string array	
	 * 
	 * @param sort sorted array provided by the user
	 * @param n size of sorted array
	 * @param fe the element the user want to search in the sorted array
	 * @return the index of the element of the if it is present in the array 
	 * 			else returns -1
	 */
			public static int binarySearchForString(String[] sort, int n,String fe) 
			{
				int start = 0;
				int end = n-1;
				while(start<=end) 
				{
					int mid = (start+end)/2;
					if(sort[mid].equalsIgnoreCase(fe)) 
					{
						return mid;
					}
					else if(sort[mid].compareTo(fe)<0) 
					{
						start = mid+1;
					}
					else 
					{
						end = mid -1;
					}
				}
				return -1;
			}

	
	/**
	 *function sort the array based on insertion sort algorithm 
	 * 
	 * @param value to hold the current value of the array
	 */
	
	public static<E extends Comparable<E>> void insertionSorting(E[] unsorted,int n) 
	{
		for(int i=1;i<=unsorted.length-1;i++) 
		{
			E value = unsorted[i];
			int hole = i;
			
			while(hole>0 && unsorted[hole-1].compareTo(value)>0) 
			{
				unsorted[hole]=unsorted[hole-1];
				hole--;
			}
			unsorted[hole]=value;
		}
		for(E ele:unsorted) 
		{
			System.out.print(ele+" ");
		}
		System.out.println();
	}
	
	/**
	 * function sort the array based on bubble sort algorithm
	 * 
	 */
	public static<E extends Comparable<E>> void bubbleSort(E[] unsorted,int n) 
	{
		for(int j=0;j<n-1;j++) 
		{
			for(int i=0;i<=n-2;i++) 
			{
				if(unsorted[i].compareTo(unsorted[i+1])>0) 
				{
					E temp = unsorted[i];
					unsorted[i]=unsorted[i+1];
					unsorted[i+1]=temp;
				}
			
			}
		}
		for(E ele: unsorted) 
		{
			System.out.print(ele+" ");
		}
	}
	
	/**
	 * function mergeSort merge the two unsorted array into a third array
	 * 
	 * @param i holds the index of left array
	 * @param j holds the index of right array
	 * @param k holds the index of third/merged array 
	 */
	public static void mergeSort(String[] left,String[] right,int lsize,int rsize,String[] array) 
	{
		int i=0,j=0,k=0;
		while(i<lsize && j<rsize) 
		{
			if((left[i].compareTo(right[j]))<0) 
			{
				array[k]=left[i];
				i++;
				k++;
			}
			else 
			{
				array[k]=right[j];
				j++;
				k++;
			}
		}
		// left or right array will get exhaust 
		while(i<lsize) 
		{
			array[k]=left[i];
			i++;
			k++;
		}
		while(j<rsize) 
		{
			array[k]=right[j];
			j++;
			k++;
		}
	}
	//dividing the array into two equal halves 
	//and inserting values in them 
	/**
	 * the function divides the array into two equal halves
	 * and insert values into them and recursively calls itself 
	 * until the array has only one element.
	 * 
	 * @param lsize to find the left array size
	 * @param rsize to find the right array size
	 * @param n
	 */
	public static void divideMerge(String[] array ,int n) 
	{
		String[] left;String[] right;
		// array has one element so it is sorted 
		//do nothing
		if(n<2) 
		{
			return;
		}
		int mid = n/2;
		int lsize = mid; //left array size
		int rsize = n-mid; //right array size
		
		//creating left and right array
		left = new String[lsize];
		right = new String[rsize];
		for(int i=0;i<=mid-1;i++) 
		{
			left[i]=array[i];
		}
		for(int i=mid;i<=n-1;i++) 
		{
			right[i-mid]=array[i];
		}
		divideMerge(left,mid);
		divideMerge(right,n-mid);
		mergeSort(left,right,mid,n-mid,array);
	}
	
	
	/**
	 * the function prints the fewest notes as well as the 
	 * minimum number of notes as a change.
	 * 
	 * @param size the size is counted to define the change array.
	 * @param numberofNotes the numberofNotes is to keep the count of minimum number of notes
	 */
	public static void numberofNotes(int amount,int[] notes) 
	{
		int size = 0;
		int numberofNotes = 0;
		//finding the size of change array...
				for(int i=0;i<notes.length;i++) 
				{
					if(amount>=notes[i]) 
					{
						size++;
					}
				}
				//creating and initializing the change array
				int[] change = new int[size];
				for(int i=0;i<change.length;i++) 
				{
					if(amount>=notes[i]) 
					{
						change[i]=notes[i];
					}
				}
				//reference array for number of notes 
				int[] count = new int[change.length];
				for(int i=0;i<change.length;i++) 
				{
					count[i]=0;
				}
				
				for(int i=(change.length-1);i>=0;i--) 
				{
					while(amount-change[i]>=0) 
					{
						amount=amount-change[i];
						numberofNotes++;
						count[i]++;
					}
				}
				for(int i=count.length-1;i>=0;i--) 
				{
					if(count[i]!=0) 
					System.out.println(count[i]+" notes of "+change[i]);
					
				}
				System.out.println("minimum number of notes : "+numberofNotes);
	}
	
	/**
	 *function takes the day as input and print the day of the week that it
	 *falls on
	 *
	 */
	public static void dayOfWeek(int month,int day,int year) 
	{
		int y0 = year-((14-month)/12);
		int x =( y0 + (y0/4)-(y0/100) + (y0/400));
		int m0 = (month + 12*((14-month)/12)-2);
		int d0 = ((day + x + 31*m0/12)%7);
		
		

		String[] days = new String[]{"sunday","monday","tuesday","wednesday","thrusday","friday","saturday"};
		
		System.out.println("day : "+days[d0]);
	}
	
	/**
	 * function convert the celsius to fahrenheit and vice versa conversion
	 * and print the desired result in the console
	 * 
	 * @param a used to hold double value
	 * @param b used to hold double value
	 * 
	 */
	public static void temperatureConversion(double temp,String tempType) 
	{
		double a = 5;
		double b = 9;
		
		if(tempType.equals("Celsius")) 
		{
			double ftemp = (temp*(b/a))+32;
			System.out.println("temperature in Fahrenheit :"+ftemp);
		}
		else 
		{
			double ctemp = (temp-32)*(a/b);
			System.out.println("temperature in Celsius :"+ctemp);
		}
	}
	/**
	 *function takes P R Y as a input,calculates and print the payment
	 *you would have to make over Y years to pay off a Principal 
	 *loan amount at R per cent interest compounded monthly
	 *
	 *@param payment to make after each month over Y years
	 */

	public static void monthlyPayment(double principal,double rateofInterest,int noofYears) 
	{
		double payment;
		double n = 12*noofYears;
		double r = (rateofInterest/(12*100));
		double term = Math.pow((1+r),(-n));
		payment = (principal*r)/(1-term);
		
		
		System.out.print("the monthly payment you have to make over "+noofYears+" years \n");
		System.out.print(" to pay off a " +principal+" loan amount\n"); 
		System.out.print("at "+rateofInterest+" per cent interest compounded monthly : "+payment);
			
	}
	
	/**
	 * function sqrt is used compute the square root of a 
	 * nonnegative number c given in the input using Newton's method
	 * and print the square root in the console.
	 * 
	 * @param epsilon is constant value;
	 */
	public static void sqrt(int number) 
	{
	
		int c = number;
		double t = c;
		double epsilon = 1e-15;
		while(Math.abs(t-(c/t))>(epsilon*t))
		{
			t=(t+c/t)/2;
		}
		System.out.println("square root of "+c+" : "+t);
		
	}
	/**
	 *function convert a decimal number into a 
	 *binary number and print it to the console
	 * 
	 */
	
	public static void toBinary(int number) 
	{
		int[] binary = new int[32];
		int indexPosition = 31;
		
			while(number/2!=0) 
			{
				binary[indexPosition]=number%2;
				number=number/2;
				indexPosition--;
			}
			binary[indexPosition]=1;
	
		
		for(int ele:binary) 
		{
			System.out.print(ele);
		}
	}
	
	/**
	 *function convert the decimal number into 
	 *binary number 
	 * 
	 */
	
	//16 decimal to binary then nibble swapping then binary to decimal and then power of 2
		public static void binaryConversion(int number) 
		{
			int[] binary = new int[8];
			int indexPosition = 7;
			
				while(number/2!=0) 
				{
					binary[indexPosition]=number%2;
					number=number/2;
					indexPosition--;
				}
				binary[indexPosition]=1;
		
			//binary array contains the binary number....
			for(int ele:binary) 
			{
				System.out.print(ele);
			}
			nibbleSwapping(binary);
		}
		/**
		 * function swaps the nibble of a binary number
		 * @param binary the binary number to swap the nibble
		 */
		public static void nibbleSwapping(int[] binary) 
		{
			String temp="";
			String temp1="";
			
			//traversing the binary array
			for(int i=0;i<binary.length;i++) 
			{
				if(i<4) 
				{
					temp=temp+binary[i];
				}
				else 
				{
					temp1=temp1+binary[i];
				}
			}
			System.out.println("\n"+"first nibble : "+temp);
			System.out.println("second nibble : "+temp1);
			//swapping the nibbles 
			String temp2 = temp1.concat(temp);
			System.out.println(temp2);
			String temp3 = 5+temp2;
			
			//binary number after...
			int afterNibbleSwapping = Integer.parseInt(temp3);
			
			//System.out.println(afterNibbleSwapping);
			
			/*for(int i=0;i<temp3.length();i++) 
			{
				if(temp3.charAt(i)!='5') 
				{
					System.out.print(temp3.charAt(i));
				}
			}*/
			//converting swapped nibble to decimal and finding it is power of 2 or not
			powerofTwo(temp2);
		}
		/**
		 * function checks that the decimal number provided by the user 
		 * is the power of 2 or not.
		 * 
		 * @param number decimal number in terms of String provided by user
		 */
		public static void powerofTwo(String number) 
		{
			int[] binaryNumber = new int[number.length()];
			for(int i=0;i<number.length();i++) 
			{
				binaryNumber[i]=Character.getNumericValue(number.charAt(i));
			}
			/*for(int ele:binaryNumber) 
			{
				System.out.print(ele+" ");
			}*/
			
			int j=0;
			int total=0;
			for(int i=(binaryNumber.length-1);i>=0;i--) 
			{
				int mul =(int)Math.pow(2, j);
				total=total+(binaryNumber[i]*mul);
				j++;
			}
			System.out.println(total);
			
			short[] powerofTwo = new short[]{1,2,4,8,16,32,64,128};
			for(int i=0;i<powerofTwo.length;i++) 
			{
				if(total==powerofTwo[i])
					System.out.println("The resultant number is a power of 2 ");
			}
		}

	
	/*
	 * Data structure
	 * 
	 */
	
	/**
	 * function deposit return the balance of current customer
	 * after performing the deposit operation
	 */
	double balance;
	public double deposit(Customer[] customer,double amount,int index) 
	{
		balance=customer[index].getmInitialBalance()+amount;
		customer[index].setmInitialBalance(balance);
		return customer[index].getmInitialBalance();
	}

	/**
	 * function withdraw return the balance of current customer
	 * after performing the withdraw operation and it also check 
	 * the condition of minimum balance
	 */
	public double withdraw (Customer[] customer,double amount,int index) 
	{
		if(customer[index].getmInitialBalance()>=amount)
		{
			balance=customer[index].getmInitialBalance()-amount;
			customer[index].setmInitialBalance(balance);
			return customer[index].getmInitialBalance();
		}
		else
		{
			return 0;
		}
	}

	/**
	 * function checkBalance return the current balance of 
	 * current customer
	 * 
	 */
	public double checkBalance(Customer[] customer,int index) 
	{
		return customer[index].getmInitialBalance();
	}

}
