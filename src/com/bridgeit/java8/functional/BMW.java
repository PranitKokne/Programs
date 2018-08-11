package com.java8.functional;

public class BMW {

	//annonymous class 
	public static void main(String[] args) {
		Car bmw = new Car() {

			@Override
			public double price() {
				return 145263.78;
			}
		};
		System.out.println(bmw.price());
	}

}
