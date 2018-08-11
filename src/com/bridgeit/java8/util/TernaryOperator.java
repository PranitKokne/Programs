package com.java8.util;

public class TernaryOperator {

	public static void main(String[] args) {

		String str = "Australia";

		String data = str.contains("A") ? "Str contains 'A'" : "Str doesn't contains 'A'";

		System.out.println(data);

		int i = 5;
		switch (i) {
		case 5:
			System.out.println("i=5");
			break;
		case 10:
			System.out.println("i=10");
			break;
		default:
			System.out.println("i is not equal to 5 or 10");
		}
		
		String number = i==10 ? "i=10": i==5? "i==5": "i!= 5 && i!=10";
		System.out.println(number);
	}

}
