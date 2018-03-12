package com.bridgeit.datastructure;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.bridgeit.utility.Utility;

public class HashingFunction {

	public static void main(String[] args) 
	{
		int[] valuecount = new int[11];
		
		Utility util = new Utility();
		
		Map<Integer,Integer> storage = new LinkedHashMap<Integer,Integer>();
		
		System.out.print("Enter a number : ");
		int numbers = util.integerInput();
		
		while(numbers!=0) 
		{
			System.out.print("Enter a number : ");
			int number = util.integerInput();
			int remaindar= number % 11;
			storage.put(number, remaindar);
			numbers--;
			valuecount[remaindar]++;
		}
		
		System.out.println(storage);
		
		//print the storage
		for(int i=0;i<valuecount.length;i++) 
		{
			Iterator<Entry<Integer,Integer>> iterator = storage.entrySet().iterator();
			while(iterator.hasNext()) 
			{
				Entry<Integer,Integer> entry = iterator.next();
				
				
			}
			
		}
		
		
	}

}
