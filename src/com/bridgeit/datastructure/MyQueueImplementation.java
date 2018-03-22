package com.bridgeit.datastructure;

public class MyQueueImplementation {

	public static void main(String[] args) 
	{
		MyQueue<Integer> myqueue = new MyQueue<Integer>();
		
		for(int i=0;i<10;i++)
			myqueue.enQueue(i);
		
		myqueue.show();
		
		for(int i=0;i<2;i++)
			System.out.println(myqueue.DeQueue());
		
		//myqueue.show();

	}

}
