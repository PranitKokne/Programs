package com.bridgeit.datastructure;

import java.util.Collections;
import java.util.LinkedList;

import com.bridgeit.utility.Utility;

public class OrderedList {

	public static void main(String[] args) 
	{
		Utility util = new Utility();
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		list.add(10);
		list.add(25);
		list.add(1);
		list.add(60);
		list.add(90);
		list.add(69);
		
		
		Collections.sort(list);
		System.out.println(list);
		
		System.out.print("Enter the number : ");
		int number = util.integerInput();
		
		boolean flag = list.contains(number);
		
		if(flag) 
		{
			for(int i=0;i<list.size();i++) 
			{
				if(list.get(i) == number) 
				{
					list.remove(i);
				}
			}
		}
		else 
		{
			list.add(number);
		}
		
		
		Collections.sort(list);
		System.out.println(list);
		
		
		
	}

}
