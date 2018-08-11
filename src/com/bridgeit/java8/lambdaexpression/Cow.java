package com.java8.lambdaexpression;

public class Cow {

	public static void main(String[] args) {
		String name = "jaanavi";
		Animal cow = () -> {
			return name;
		};
		System.out.println(cow.name());
	}
}
