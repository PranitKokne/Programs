package com.java8.functional;

public class Virat implements Cricket {

	@Override
	public int numberOfRuns(int runs) {
		return runs;
	}
	
	@Override
	public int numberOfWickets(int wickets) {
		return wickets+1;
	}
	
	public static void main(String[] args) {
		Cricket virat = new Virat();
		System.out.println("Player Name :" + Cricket.playerName("Virat Kohli"));
		System.out.println("number of runs scored by above player is " + virat.numberOfRuns(10587));
		System.out.println("Number of wickets taken by above player is " + virat.numberOfWickets(15));
	}

}
