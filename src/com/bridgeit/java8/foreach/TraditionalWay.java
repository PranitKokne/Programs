package com.java8.foreach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TraditionalWay {

	/*
	 * let's say in this class i will define a method whose job is to take one
	 * number as a input and tell whether it's prime(true) or non-prime(false). and
	 * i will call that method from while loop and based on the response i will
	 * print the prime numbers only.
	 *
	 * so in this case the iteration logic and the business logic is at the same
	 * place. line no. 27 to 31
	 */

	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<Integer>();

		// populating the list
		for (int i = 0; i < 15; i++)
			myList.add(i);

		Iterator<Integer> iterator = myList.iterator();
		while (iterator.hasNext()) {
			Integer number = iterator.next();
			System.out.println(number);
		}
	}

}
