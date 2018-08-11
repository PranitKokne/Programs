package com.java8.functional;

public class MyCar implements Car {

	@Override
	public double price() {
		return 125087.23;
	}

	// class implementing interface and giving implementation
	public static void main(String[] args) {
		Car tesla = new MyCar();
		System.out.println(tesla.price());
	}
}
