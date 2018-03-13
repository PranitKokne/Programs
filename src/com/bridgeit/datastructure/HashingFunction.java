/**
 * Purpose :The program takes inputs from user and arrange them in a particular order
 * 			in a map then it asks the user to enter a number and it checks 
 * 			whether the number is present in the map or not.if yes then it removes the
 * 			corresponding entry from map else it add that number to the map.
 * 			 
 * @author Pranit_Kokne
 * @version 1.0
 * @since 13-03-2018
 *
 */

package com.bridgeit.datastructure;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import com.bridgeit.utility.Utility;

public class HashingFunction {

	/**
	 * the function returns the keys mapped to multiple values
	 * 
	 * @param map containing the <K,V> pairs
	 * @param value mapped to the key
	 * @return keys present in the map
	 */
	public static <T, E> LinkedHashSet<T> getKeysByValue(Map<T, E> map, E value) {
	    LinkedHashSet<T> keys = new LinkedHashSet<T>();
	    for (Entry<T, E> entry : map.entrySet()) {
	        if (Objects.equals(value, entry.getValue())) {
	            keys.add(entry.getKey());
	        }
	    }
	    return keys;
	}
	
	/**
	 * the function print the map in a particular structure
	 *
	 */
	public static void display(int[] count,LinkedHashMap<Integer,Integer> map) 
	{
		for(int i=0;i<count.length;i++)
		{
			LinkedHashSet<Integer> keys = getKeysByValue(map,i);
			System.out.println(i+"--->"+keys);
		}
	}
	
	/**
	 *the main function stores the <K,V> pair in the map then it asks the user 
	 *to enter a number if the number is present in the map then it removes that
	 *corresponding number from map else it put the number into the map.
	 */
	public static void main(String[] args) 
	{
		Utility util = new Utility();
		//to store the count 
		int[] count = new int[11];
		
		//defining the LinkedHashMap
		LinkedHashMap<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
		
		//adding the entries into map
		System.out.print("Enter the number of entries you want in map : ");
		int entries = util.integerInput();
		
		while(entries!=0) 
		{
			System.out.print("Enter the key : ");
			int key = util.integerInput();
			int value = key % 11;
			
			count[value]++;
			
			map.put(key, value);
			entries--;
		}
	
		System.out.println(map);
		
		//printing the map in a required manner
		display(count,map);
		
		//taking the number from user
		System.out.print("Enter the number : ");
		int number = util.integerInput();
		int search = number % 11;
		
		
		LinkedHashSet<Integer> row = getKeysByValue(map,search);
		
		System.out.println(row);
		//if true removing the number else inserting it to map
		if(row.contains(number))
		{
			map.remove(number);
		}
		else
		{
			map.put(number, search);
		}
		
		System.out.println(map);
		
		//printing the map in a required manner
		display(count,map);
	}

}
