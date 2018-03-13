package com.bridgeit.datastructure;

import java.util.NoSuchElementException;

public class MyStack<T> 
{
	Node top;
	int size;
	
	public MyStack() 
	{
		top = null;
		size = 0;
	}
	
	public int size() 
	{
		return size;
	}
	
	public boolean isEmpty() 
	{
		return top == null;
	}
	
	public <T> void push(T item) 
	{
		Node node = new Node(item,null);
		if(top==null) 
		{
			top = node;
		}
		else 
		{
			node.next = top;
			top = node;
		}
		size++;
	}
	
	
	public T pop() 
	{
		if(isEmpty())
		{
			throw new NoSuchElementException("Underflow condition");
		}
		Node temp = top;
		top = temp.next;
		size--;
		return (T)temp.data;
	}


}
