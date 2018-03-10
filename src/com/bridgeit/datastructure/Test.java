package com.bridgeit.datastructure;

public class Test {

	public static void main(String[] args) 
	{
		LinkedList<Integer> mylist = new LinkedList<Integer>();
		
		/*mylist.add(10);
		mylist.add(50);
		
		mylist.show();*/
		
		LinkedList<String> namelist = new LinkedList<String>();
		
		namelist.add("pranit");
		namelist.add("anita");
		namelist.add("messi");
		namelist.add(null);
		namelist.add("pranit");
		namelist.add(null);
		namelist.addFirst("sachin");
		
		namelist.show();
		namelist.deleteByItem("pranit");
		namelist.addLast("james");
		namelist.addAt(3,"kokne");
		namelist.show();
		
		/*System.out.println(namelist.isEmpty());
		System.out.println(namelist.size());
		System.out.println(mylist.isEmpty());
		System.out.println(mylist.size());*/
		

	}

}
