package com.bridgeit.designpattern;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadAddressBookFacade {
	
	public static void readBook(String path) 
	{
		JSONArray book;
		JSONParser parser = new JSONParser();
		
		try {
			book = (JSONArray) parser.parse(new FileReader(path));
			for(int i=0;i<book.size();i++) 
			{
				JSONObject person = (JSONObject) book.get(i);
				displayPerson(person);
			}
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void displayPerson(JSONObject person) 
	{
		System.out.println("First Name : "+(String)person.get("First Name"));
		System.out.println("Last Name : "+(String)person.get("Last Name"));
		System.out.println("Address : "+(String)person.get("Address"));
		System.out.println("City : "+(String)person.get("City"));
		System.out.println("State : "+(String)person.get("State"));
		System.out.println("Phone Number : "+(long)person.get("Phone Number"));
		System.out.println("Zip : "+(long)person.get("Zip"));
		System.out.println();
	}
}
