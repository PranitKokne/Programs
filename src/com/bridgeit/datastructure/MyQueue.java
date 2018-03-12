package com.bridgeit.datastructure;

public class MyQueue<T>
{
	Node front;
	Node rear;
	
	public MyQueue() 
	{
		front = null;
		rear = null;
	}
	
	public <T> void enQueue(T item) 
	{
		Node node = new Node(item,null);
		//in case of first enQueue operation
		if(front == null && rear == null)  
		{
			front = node;
			rear = node;
		}
		else
		{
			rear.next = node;
			rear = node;
		}
		
	
	}
	
	
	public <T> void deQueue() 
	{
		Node temp = front;
		if(front != rear) //in case of multiple nodes 
		{
			front = front.next;
		}
		else //incase of last node
		{
			front = null;
			rear = null;
		}
	}
	
	public void show() 
	{
		Node temp = front;
		while(temp.next != null) 
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println(temp.data);
	}


}
