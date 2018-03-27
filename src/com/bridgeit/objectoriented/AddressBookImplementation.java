package com.bridgeit.objectoriented;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgeit.utility.Utility;

/**
 * Purpose :The class contains the methods required to perform the operation in the case of address book
 * 
 * @author Pranit_Kokne
 * @version 1.0
 * @since 27/03/2018
 *
 */
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
	
	
	/**
	 * the method update the existing person information
	 * 
	 * @param firstName of the person on the basis of which information is updated 
	 * @param lastName of the person to be updated
	 * @param address of the person to be updated
	 * @param city of the person to be updated
	 * @param state of the person to be updated
	 * @param zip of the person to be updated
	 * @param phoneNumber of the person to be updated
	 * @return true if the edit operation is successful else false
	 */
	public static boolean editPersonInformation(String firstName,String lastName,String address,String city,String state,long zip,long phoneNumber) 
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
					updatedHuman.put("First Name", firstName);
					updatedHuman.put("Last Name", lastName);
					updatedHuman.put("Address", address);
					updatedHuman.put("City", city);
					updatedHuman.put("State", state);
					updatedHuman.put("Zip", zip);
					updatedHuman.put("Phone Number", phoneNumber);
				}
				else 
				{
					updatedHuman.put("First Name", human.get("First Name"));
					updatedHuman.put("Last Name", human.get("Last Name"));
					updatedHuman.put("Address", human.get("Address"));
					updatedHuman.put("City", human.get("City"));
					updatedHuman.put("State", human.get("State"));
					updatedHuman.put("Zip", human.get("Zip"));
					updatedHuman.put("Phone Number", human.get("Phone Number"));
				}
				updatedPerson.add(updatedHuman);
			}
			result = Utility.fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/addressbook/Person.json", updatedPerson);
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
	 * the method use the insertion sort algorithm to sort the array.
	 * @param unsorted array pass by the user to sort
	 * @param size of the array to be sorted
	 * @return the sorted array
	 */
	public static<E extends Comparable<E>> E[] insertionSorting(E[] unsorted,int size) 
	{
		for(int i=1;i<=unsorted.length-1;i++) 
		{
			E value = unsorted[i];
			int hole = i;
			
			while(hole>0 && unsorted[hole-1].compareTo(value)>0) 
			{
				unsorted[hole]=unsorted[hole-1];
				hole--;
			}
			unsorted[hole]=value;
		}
		return unsorted;
	}
	
	/**
	 * the method sort the person on the basis of zip code.
	 * @return true if the sorting is successful else false.
	 */
	public static boolean sortByZip() 
	{
		JSONParser parser = new JSONParser();
		JSONArray updatedPerson = new JSONArray();
		JSONObject human;
		try 
		{
			JSONArray person = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/addressbook/Person.json"));
			
			Long[] zip = new Long[person.size()];
			
			for(int i=0;i<person.size();i++) 
			{
				human = (JSONObject) person.get(i);
				
				JSONObject updatedHuman = new JSONObject();
	
				zip[i] = (long) human.get("Zip");	
			}
			Long[] sortedZip = insertionSorting(zip,zip.length);
			
			
			
			for(int j=0;j<sortedZip.length;j++) 
			{
				for(int k=0;k<person.size();k++) 
				{
					human = (JSONObject) person.get(k);
					if(sortedZip[j] == (long)human.get("Zip")) 
					{
						updatedPerson.add(human);
					}
				}
			}
			result = Utility.fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/addressbook/PersonSortByZip.json", updatedPerson);
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
	 * the method sort the person on the basis of last name.
	 * @return true if the sorting is successful else false.
	 */
	public static boolean sortByLastName() 
	{
		JSONParser parser = new JSONParser();
		JSONArray updatedPerson = new JSONArray();
		JSONObject human;
		try 
		{
			JSONArray person = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/addressbook/Person.json"));
			
			String[] lastname = new String[person.size()];
			
			for(int i=0;i<person.size();i++) 
			{
				human = (JSONObject) person.get(i);
				
				JSONObject updatedHuman = new JSONObject();
	
				lastname[i] = (String) human.get("Last Name");	
			}
			String[] sortedLastName = insertionSorting(lastname,lastname.length);
			
			
			
			for(int j=0;j<sortedLastName.length;j++) 
			{
				for(int k=0;k<person.size();k++) 
				{
					human = (JSONObject) person.get(k);
					if(sortedLastName[j] == (String)human.get("Last Name")) 
					{
						updatedPerson.add(human);
					}
				}
			}
			result = Utility.fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/addressbook/PersonSortByLastName.json", updatedPerson);
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
	
}
