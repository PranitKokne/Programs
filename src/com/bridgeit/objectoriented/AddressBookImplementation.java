package com.bridgeit.objectoriented;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgeit.utility.Utility;

public class AddressBookImplementation {

	static boolean result;
	/**
	 * the method delete the person  from the array containing persons 
	 * 
	 * @param firstName of the person to be deleted
	 * @return true if the deletion is successful else false
	 */
	public static boolean deletePersonByName(String firstName)
	{
		JSONParser parser = new JSONParser();
		
		try 
		{
			JSONArray person = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/addressbook/Person.json"));
			
			for(int i=0;i<person.size();i++) 
			{
				JSONObject human = (JSONObject) person.get(i);
				String fname = (String) human.get("First Name");
				if(fname.equals(firstName)) 
				{
					person.remove(i);
				}
				
			}
			result = Utility.fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/addressbook/Person.json", person);
			if(result) 
			{
				return true;
			}
		}
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}
	/**
	 * the method print all the entries present from the person array
	 */
	public static void printAllEntries() 
	{
		JSONParser parser = new JSONParser();
		
		try 
		{
			JSONArray person = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/addressbook/Person.json"));
			
			for(int i=0;i<person.size();i++) 
			{
				JSONObject human = (JSONObject) person.get(i);
				String fname = (String) human.get("First Name");
				String lname = (String) human.get("Last Name");
				String address = (String) human.get("Address");
				String city = (String) human.get("City");
				String state = (String) human.get("State");
				long zip = (long) human.get("Zip");
				long phoneNumber = (long) human.get("Phone Number");
				
				System.out.println(fname+" "+lname);
				System.out.println(address);
				System.out.println(city+", "+state);
				System.out.println(zip);
				System.out.println(phoneNumber+"\n");
				
			}
			
		}
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public static boolean editPersonInformation(String firstName,String address,String city,String state,long zip,long phoneNumber) 
	{
		JSONParser parser = new JSONParser();
		JSONArray updatedPerson = new JSONArray();
		try 
		{
			JSONArray person = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/addressbook/Person.json"));
			for(int i=0;i<person.size();i++) 
			{
				JSONObject updatedHuman = new JSONObject();
				JSONObject human = (JSONObject) person.get(i);
				if(firstName.equals(human.get("First Name"))) 
				{
					
				}
				else 
				{
					
				}
			}
			
		} 
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}

		
		
		return false;
	}
	
}
