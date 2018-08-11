package com.java8.lambdaexpression;

public class Addition {
	
	public static void main(String[] args) {
		ArithmeticOperation addition = (num) -> num+5;
		System.out.println(addition.incrementByFive(15));
	}
}
