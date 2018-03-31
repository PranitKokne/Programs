package com.bridgeit.designpattern;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadAddressBookWFacade {
	
	
	
	public static JSONArray getArray(String path) 
	{
		JSONArray book;
		JSONParser parser = new JSONParser();
		
		try {
			book = (JSONArray) parser.parse(new FileReader(path));
			return book;
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public static JSONObject getObject(JSONArray book,int index) 
	{
		JSONObject person = (JSONObject) book.get(index);
		return person;
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
