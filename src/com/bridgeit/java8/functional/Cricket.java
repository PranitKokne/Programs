package com.java8.functional;

@FunctionalInterface
public interface Cricket {

	int numberOfRuns(int runs);

	static String playerName(String name) {
		return name;
	}

	default int numberOfWickets(int wickets) {
		return wickets;
	}
}
