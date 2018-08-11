package com.java8.foreach;

import java.util.function.Consumer;

public class MyConsumer implements Consumer<Integer> {

	/*
	 * here i will have the function whose job is to identify if the number is prime
	 * or not from the accept method i will call the function and based on the
	 * response i will print the prime numbers so my business logic resides in this
	 * class where the iteration logic resides in the other class
	 * 
	 */

	@Override
	public void accept(Integer t) {
		System.out.println("Consumer Impl Value: " + t);
	}

}
