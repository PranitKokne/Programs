package com.bridgeit.datastructure;

public class Test {

	public static void main(String[] args) 
	{
		MyLinkedList<Integer> mylist = new MyLinkedList<Integer>();
		
		mylist.add(10);
		mylist.add(50);
		mylist.deleteByValue(10);
		mylist.show();
		
		MyLinkedList<String> namelist = new MyLinkedList<String>();
		
		namelist.add("pranit");
		namelist.add("anita");
		namelist.add("messi");
		namelist.add("pranit");
		
		namelist.addFirst("sachin");
		

		namelist.addLast("james");
		namelist.addAt(3,"kokne");
		namelist.show();
		
		System.out.println(mylist.search(20));
		System.out.println(namelist.search("pranit"));
		//System.out.println(namelist.search(null));
		
		System.out.println(namelist.search("messI"));
		namelist.show();
		
		namelist.deleteByValue("sachin");
		namelist.show();

	}

}
