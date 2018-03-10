package com.bridgeit.datastructure;

import com.bridgeit.utility.Utility;


public class LinkedList<T> 
{
	//head node 
	Node head;	
	
	//insert at the end of the list 
	public <E> void add(E data) 
	{
		Node node = new Node(data,null);
				
		if(head == null) 
		{
			head = node;
		}
		else 
		{
			Node temp = head;
			while(temp.next != null) 
			{
				temp = temp.next;
			}
			temp.next = node;
		}	
	}
	
	//insert at the start
	public <E> void addFirst(E data) 
	{
		Node node = new Node(data,null);
		node.data = data;
		node.next = null;
			
		node.next = head;
		head = node;
	}
	//insert at the end
	public <E>void addLast(E data) 
	{
		add(data);
	}
	
	//insert at a particular index 
	public <E> void addAt(int index,E data) 
	{
		Node node = new Node(data,null);
				
		if(index == 0) 
		{
			addFirst(data);
		}
		else 
		{
			Node temp = head;
			for(int i=0;i<index-1;i++) 
			{
				temp = temp.next;
			}
			node.next = temp.next;
			temp.next = node;
		}
	}
	//size of the list
	public int size() 
	{
		int count = 0;
		Node temp = head;
		while(temp!=null) 
		{
			count++;
			temp = temp.next;
		}
		return count;	
	}
	
	//list is empty or not
	public boolean isEmpty() 
	{
		if(head==null) 
		{
			return true;
		}
		
		return false;
	}
	
	//remove element based on index
	public void deleteByIndex(int index) 
	{
		if(index==0) 
		{
			head = head.next;
		}
		else 
		{
			Node temp = head;
			Node n1 = null;
			for(int i=0;i<index-1;i++) 
			{
				temp = temp.next;
			}
			n1 = temp.next;
			temp.next = n1.next;
			
			n1.next=null;
		}
	}
	
	public <E> void deleteByItem(E item) 
	{
		Node temp = head;
		Node prev = null;
		
		//removing the head node
		if(temp != null && temp.data==item) 
		{
			head = temp.next;
		}
		
		while(temp != null && temp.data!=item) 
		{
			prev = temp;
			temp = temp.next;
		}
		
		//if the item is not present in the linked list then do nothing
		if(temp==null)
			return;
		
		prev.next = temp.next;	
	}
	
	//print the list 
	public void show() 
	{
		Node temp = head;
		while(temp.next!=null) 
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.print(temp.data);
		Utility.lineCursor();
	}
	
	

}
