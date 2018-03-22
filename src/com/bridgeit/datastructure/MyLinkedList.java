package com.bridgeit.datastructure;



public class MyLinkedList<T> 
{
	Node head;
	
	//add
	public <T> void add(T item) 
	{
		Node<T> node = new Node(item,null);
		
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
	public <T> void addFirst(T item) 
	{
		Node node = new Node(item,null);
			
		node.next = head;
		head = node;
	}
	//insert at the end
	public <T> void addLast(T item) 
	{
		add(item);
	}
	
	//insert at a particular index 
	public <T> void addAt(int index,T item) 
	{
		Node node = new Node(item,null);
				
		if(index == 0) 
		{
			addFirst(item);
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
			Node node1 = null;
			for(int i=0;i<index-1;i++) 
			{
				temp = temp.next;
			}
			node1 = temp.next;
			temp.next = node1.next;
			
			node1.next=null;
		}
	}
	
	/*public <E> void deleteByItem(E item) 
	{
		Node temp = head;
		Node prev = null;
		
		//removing the head node
		if(temp != null && temp.data==item) 
		{
			head = temp.next;
			return;
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
	}*/
	
	//search element in the list
	public <T> boolean  search(T item) 
	{
		Node<T> current = head;
		
		while(current!=null) 
		{
			if(current.data.equals(item)) 
			{
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	public <T> void deleteByValue(T item) 
	{
		Node temp = head;
		Node prev = null;
		
		if(item instanceof String) 
		{
			//removing the head node
			if(temp != null && temp.data.equals(item)) 
			{
				head = temp.next;
				return;
			}
			
			while(temp != null && !(temp.data.equals(item))) 
			{
				prev = temp;
				temp = temp.next;
			}
			
			//if the item is not present in the linked list then do nothing
			if(temp==null)
				return;
			
			prev.next = temp.next;	
		}
		else 
		{
			if(temp != null && temp.data==item) 
			{
				head = temp.next;
				return;
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
	}
	
	//get method 
		public T get(int index) 
		{
			Node temp = head;
			for(int i=0;i<index;i++) 
			{
				temp = temp.next;
			}
			return (T)temp.data;
		}
		
		//set method
		public void set(int index,T value) 
		{
			Node temp = head;
			for(int i=0;i<index;i++) 
			{
				temp = temp.next;
			}
			temp.data = value;
		}	
		
	//show
	public void show() 
	{
		Node temp = head;
		while(temp.next != null) 
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println(temp.data);
	}
	
	//overriding the toString method 
	public String toString() 
	{
		String result = "";
		Node temp = head;
		while(temp.next != null) 
		{
			result = result+temp.data+" ";
			temp = temp.next;
		}
		return result+temp.data+" ";
	}

}
