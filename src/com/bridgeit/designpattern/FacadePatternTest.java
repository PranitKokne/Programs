package com.bridgeit.designpattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class FacadePatternTest {

	public static void main(String[] args) {
		
		JSONArray addressBook ;
		JSONObject person;
		//reading the address book without using the facade pattern
		addressBook = ReadAddressBookWFacade.getArray("/home/bridgeit/Pranit/Programs/JSONFiles/addressbook/Person.json"); 
		
		for(int i=0;i<addressBook.size();i++) 
		{
			person = ReadAddressBookWFacade.getObject(addressBook,i);
			ReadAddressBookWFacade.displayPerson(person);
		}
		
		//reading address book by using facade pattern
		ReadAddressBookFacade.readBook("/home/bridgeit/Pranit/Programs/JSONFiles/addressbook/Person.json");
		
	}

}
