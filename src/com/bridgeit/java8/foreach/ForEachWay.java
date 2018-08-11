package com.java8.foreach;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ForEachWay {

	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<Integer>();

		// populating the int list
		for (int i = 0; i < 15; i++) {
			myList.add(i);
		}

		// annonymous class implementation
		myList.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println("forEach annonymous value : " + t);
			}

		});

		/*
		 * my job is to display the only prime number from the list of numbers so here i
		 * am calling the forEach method and passing the consumer object as a argument.
		 * so my iteration logic resides here and my business logic will be in the
		 * implementation class who is implementing the consumer interface and giving
		 * the implementation to the accept method.
		 * 
		 */

		MyConsumer action = new MyConsumer();
		myList.forEach(action);

	}

}
