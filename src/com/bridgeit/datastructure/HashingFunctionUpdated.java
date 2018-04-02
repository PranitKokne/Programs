package com.bridgeit.datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import com.bridgeit.utility.Utility;

public class HashingFunctionUpdated 
{
	/**
	 * the function returns the keys mapped to multiple values
	 * 
	 * @param map containing the <K,V> pairs
	 * @param value mapped to the key
	 * @return keys present in the map
	 */
	public static <T, E> LinkedHashSet<T> getKeysByValue(Map<T, E> map, E value) 
	{
	    LinkedHashSet<T> keys = new LinkedHashSet<T>();
	    for (Entry<T, E> entry : map.entrySet()) 
	    {
	        if (Objects.equals(value, entry.getValue())) 
	        {
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
	 * the function reads the numbers from a file and add it to the map
	 * 
	 * @param map to which numbers are added
	 * @param count to keep a track of numbers associated with each index 
	 * @return the map
	 */
	public static LinkedHashMap<Integer,Integer> addNumbersToMap(LinkedHashMap<Integer,Integer> map,int[] count)
	{
		String line = null;
		String[] numbers = null;
		FileReader fileReader;
		try 
		{
			fileReader = new FileReader("/home/bridgeit/Pranit/files/numbers.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while((line = bufferedReader.readLine())!=null) 
			{
				 numbers = line.split(" ");
			}
			fileReader.close();
			bufferedReader.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
		Integer[] num = new Integer[numbers.length];
		for(int i=0;i<numbers.length;i++)
		{
			int key =  Integer.parseInt(numbers[i]);
			int value = key % 11;
			count[value]++;
			map.put(key, value);
		}
		return map;
	}

	/**
	 * the function write the map's key into the file
	 *  
	 * @param map to write it to the file
	 * @return true if the operation is successful else false
	 */
	public static boolean writeMapIntoFile(LinkedHashMap<Integer,Integer> map) 
	{
		String temp = "";
		for(Integer key : map.keySet()) 
		{
			temp = temp + key + " ";
		}
		FileWriter fileWriter;
		try 
		{
			fileWriter = new FileWriter("/home/bridgeit/Pranit/files/numbers.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(temp);
			
			bufferedWriter.close();
			fileWriter.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
		return false;
	}
	
	public static void main(String[] args) 
	{
		Utility util = new Utility();
		//to store the count 
		int[] count = new int[11];
		
		//defining the LinkedHashMap
		LinkedHashMap<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
		
		//adding the entries into map
		
		map = addNumbersToMap(map,count);
		
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
		
		writeMapIntoFile(map);

	}
}
