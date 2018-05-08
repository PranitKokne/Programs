package com.bridgeit.datastructure;

public class MyDeque<T> 
{
	Node head;
	Node tail;
	
	public <T> MyDeque()
	{
		head = null;
		tail = null;		
	} 
	
	public <T> boolean add(T item)
	{
		Node node = new Node(item,null);
		//incase it is a first add operation
		if(tail == null) 
		{
			tail = node;
		}
		else 
		{
			Node temp = tail;
			temp.next = node.next;
			tail = node;
		}
		
		return true;
	}

}
