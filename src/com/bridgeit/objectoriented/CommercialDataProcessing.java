package com.bridgeit.objectoriented;

import java.io.File;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgeit.utility.Utility;

public class CommercialDataProcessing 
{
	public static void main(String[] args) 
	{
		File file = new File("/home/bridgeit/Pranit/Programs/JSONFiles/Customers.json");
		boolean result = false;
		
		Utility util = new Utility();
		
		System.out.println("Press 1 to open an account");
		System.out.println("Press 2 to buy shares");
		System.out.println("Press 3 to sell shares");
		System.out.println("Press 4 to see the available shares of companies");
		System.out.println("Press 5 to check the portfolio's value");
		System.out.println("Press 6 to update your account details");
		System.out.println("Press any other key to exit");
			
		String name;
		long mobileNumber;
		String emailId;
		double balance;

		JSONArray customers = new JSONArray();
		

		boolean flag = true;
		while(flag)
		{
			
			
			System.out.print("Enter your choice : ");
			int choice = util.integerInput();
			util.inputStringLine();
			switch(choice) 
			{
			case 1:
				
				try {
					result = file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}

				System.out.print("Enter the name : ");
				name = util.inputStringLine();
				System.out.print("Enter the mobile number : ");
				mobileNumber = util.longInput();
				util.inputStringLine();
				System.out.print("Enter the Email Id : ");
				emailId = util.inputStringLine();
				System.out.print("Enter the amount for trading : ");
				balance = util.doubleInput();
				
				JSONObject customer = new JSONObject();
				customer.put("Name", name);
				customer.put("Mobile Number", mobileNumber);
				customer.put("Email Id", emailId);
				customer.put("Balance", balance);
				
				if(result) 
				{
					customers.add(customer);
					Utility.fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/Customers.json",customers);
				}
				else 
				{
					Utility.fileReadingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/Customers.json",customer);
				}
				break;
				
			case 2:
				
				break;
				
			case 3:
				
				break;
				
			case 4:
				
				break;
				
			case 5:
				
				break;
				
			case 6:
				
				break;
				
			default:
				System.exit(0);
				
			}
		}
		
	}

}
