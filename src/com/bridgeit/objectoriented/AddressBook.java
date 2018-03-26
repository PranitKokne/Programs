package com.bridgeit.objectoriented;

import java.io.File;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgeit.utility.Utility;

public class AddressBook {

	public static void main(String[] args) 
	{
		Utility util = new Utility();
		
		File file = new File("/home/bridgeit/Pranit/Programs/JSONFiles/addressbook/Person.json");
		boolean fileCreationResult = false;
		
		System.out.println("Press 1 to add a new person to address book");
		System.out.println("Press 2 to edit the existing person information");
		System.out.println("Press 3 to delete a person");
		System.out.println("Press 4 to sort the entries in the address book by last name");
		System.out.println("Press 5 to sort the entries in the address book by zip code");
		System.out.println("Press 6 to print all the entries in the address book");
		System.out.println("Press any key to exit");
		
		String firstName;
		String lastName;
		String address;
		String city;
		String state;
		long zip;
		long phoneNumber;
		JSONArray person = new JSONArray();
		
		
		boolean flag = true;
		while(flag) 
		{
			System.out.print("Enter your choice : ");
			int choice = util.integerInput();
			
			boolean operationResult = false;
			
			switch(choice) 
			{
			case 1:
				try {
					fileCreationResult = file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.print("Enter the First Name : ");
				firstName = util.inputString();
				System.out.print("Enter the Last Name : ");
				lastName = util.inputString();
				System.out.print("Enter the Address : ");
				util.inputStringLine();
				address = util.inputStringLine();
				System.out.print("Enter the City : ");
				city = util.inputStringLine();
				System.out.print("Enter the state : ");
				state = util.inputStringLine();
				System.out.print("Enter the zip code : ");
				zip = util.longInput();
				System.out.print("Enter the phone number : ");
				phoneNumber = util.longInput();
				
				JSONObject onePerson = new JSONObject();
				onePerson.put("First Name", firstName);
				onePerson.put("Last Name", lastName);
				onePerson.put("Address", address);
				onePerson.put("City", city);
				onePerson.put("State", state);
				onePerson.put("Zip", zip);
				onePerson.put("Phone Number", phoneNumber);
				
				
				if(fileCreationResult) 
				{
					person.add(onePerson);
					Utility.fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/addressbook/Person.json", person);
				}
				else 
				{
					Utility.fileReadingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/addressbook/Person.json", onePerson);
				}
				break;
				
			case 2:
				System.out.print("Enter the First Name of the person you want to edit : ");
				firstName = util.inputString();
				System.out.print("Enter the Address : ");
				util.inputStringLine();
				address = util.inputStringLine();
				System.out.print("Enter the City : ");
				city = util.inputStringLine();
				System.out.print("Enter the state : ");
				state = util.inputStringLine();
				System.out.print("Enter the zip code : ");
				zip = util.longInput();
				System.out.print("Enter the phone number : ");
				phoneNumber = util.longInput();
				
				operationResult = AddressBookImplementation.editPersonInformation(firstName,address,city,state,zip,phoneNumber);
				break;
				
			case 3:
				System.out.print("Enter the First Name : ");
				firstName = util.inputString();
				operationResult = AddressBookImplementation.deletePersonByName(firstName);
				if(operationResult) 
				{
					System.out.println("Deleted successfully");
				}
				else 
				{
					System.out.println("Error in deleting");
				}
				break;
				
			case 4:
				
				break;
				
			case 5:
				
				
				break;
				
			case 6:
				AddressBookImplementation.printAllEntries();
				break;
				
			default:
				flag = false;
				System.exit(0);
			}
			
		}
		
	}

}
