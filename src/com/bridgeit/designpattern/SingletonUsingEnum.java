package com.bridgeit.designpattern;

public class SingletonUsingEnum 
{
	public enum SingletonEnum
	{
		INSTANCE;
		
		public void doSomething() 
		{
			System.out.println("Singleton pattern is overrated");
		}
	}
	
	public static void main(String[] args) 
	{
		SingletonEnum sue = SingletonEnum.INSTANCE;
		SingletonEnum sue1 = SingletonEnum.INSTANCE;
		System.out.println(sue.hashCode());
		System.out.println(sue1.hashCode());
		
		sue.doSomething();
		
		sue1.doSomething();
		
		
	}
	
	
	
	
	
	
	
}
