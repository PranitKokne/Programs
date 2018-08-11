package com.java8.lambdaexpression;

import java.util.ArrayList;
import java.util.List;

public class TraverseList {

	public static void main(String[] args) {
		List<String> teamPlayers = new ArrayList<String>();
		teamPlayers.add("Virat");
		teamPlayers.add("Ajinkya");
		teamPlayers.add("Rohit");
		teamPlayers.add("Rahul");
		teamPlayers.add("Jaspreet");

		teamPlayers.forEach((name) -> System.out.println(name));
	}
}
