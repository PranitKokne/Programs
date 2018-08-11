package com.java8.lambdaexpression;

import java.util.LinkedHashMap;
import java.util.Map;

public class TraverseMap {

	public static void main(String[] args) {
		Map<String, Integer> shares = new LinkedHashMap<>();
		shares.put("Nike", 5412);
		shares.put("Adidas", 1234);
		shares.put("Puma", 7895);
		shares.put("Reebok", 1203);
		shares.put("Umbro", 4510);

		for (Map.Entry<String, Integer> share : shares.entrySet()) {
			System.out.println("Share Name : " + share.getKey() + "Share Price : " + share.getValue());
		}

		System.out.println("Lambda Expression Magic");
		shares.forEach((K, V) -> System.out.println("Share Name : " + K + " Share Price : " + V));
	}
}
