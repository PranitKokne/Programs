package com.bridgeit.datastructure;

public class MyStackOperation {

	public static void main(String[] args) 
	{
		
		MyStack<Integer> mystack = new MyStack<Integer>();
		
		for(int i=1;i<=31;i++)
			mystack.push(i);
		
		
		
		System.out.println(mystack.size);
		System.out.println(mystack.isEmpty());
		
		for(int i=1;i<=31;i++)
			System.out.println(mystack.pop());

	}

}
