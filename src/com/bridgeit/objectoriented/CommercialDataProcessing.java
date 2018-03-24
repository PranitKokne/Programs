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
		
		File secondFile = new File("/home/bridgeit/Pranit/Programs/JSONFiles/CustomersPortfolio.json");
		boolean secondResult = false;
		
		
		Utility util = new Utility();
		StockAccount account = new StockAccount();
		
		System.out.println("Press 1 to open an account");
		System.out.println("Press 2 to buy shares");
		System.out.println("Press 3 to sell shares");
		System.out.println("Press 4 to see the available shares of companies");
		System.out.println("Press 5 to check the portfolio's value");
		System.out.println("Press any other key to exit");
			
		String name;
		long mobileNumber;
		String emailId;
		double balance;
		long accountNo;
		
		String shareName;
		long numberofShares;
		
		boolean feedback;
		
		JSONArray customers = new JSONArray();
		JSONArray customersPortfolio = new JSONArray();
		
		JSONArray shareNames = new JSONArray();
		JSONArray noofShares = new JSONArray();

		
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
				System.out.print("Choose an numeric account number : ");
				accountNo = util.longInput();
				
				JSONObject customer = new JSONObject();
				customer.put("Name", name);
				customer.put("Mobile Number", mobileNumber);
				customer.put("Email Id", emailId);
				customer.put("Balance", balance);
				customer.put("Account Number", accountNo);
				
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
				try {
					secondResult = secondFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				System.out.println("Shares Details");
				//account.printReport();
				System.out.print("Enter your account Number : ");
				accountNo = util.longInput();
				//check whether account no is valid or not
				feedback = account.authentication(accountNo);
				if(feedback) 
				{
					System.out.print("Enter the company name whose share you want to buy : ");
					shareName = util.inputString();
					System.out.print("Enter the number of shares you want : ");
					numberofShares = util.longInput();
				
					JSONObject portfolio = new JSONObject();
					portfolio.put("Account Number", accountNo);
					shareNames.add(shareName);
					portfolio.put("Share Names", shareNames);
					noofShares.add(numberofShares);
					portfolio.put("Shares", noofShares);
				//before adding check whether the same object is present in the array or not
				//if yes remove it else not.
											
					if(secondResult) 
					{
						customersPortfolio.add(portfolio);
						Utility.fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/CustomersPortfolio.json",customersPortfolio);
					}
					else 
					{
						Utility.fileReadingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/CustomersPortfolio.json",portfolio);
					}
					//call buy method
					System.out.println(shareName+"'s "+numberofShares+" shares added to your account");
				}
				else 
				{
					System.out.println("Invalid Account Number");
				}
				
				break;
				
			case 3:
				
				break;
				
			case 4:
				System.out.println("over view of comapanies share price");
				account.printReport();
				break;
				
			case 5:
				System.out.print("Enter your account number : ");
				accountNo = util.longInput();
				feedback = account.authentication(accountNo);
				if(feedback) 
				{
					//portfolio value calculate
					String[] sharename = account.shareName("/home/bridgeit/Pranit/Programs/JSONFiles/Shares.json","Company Name");
					long[] price = account.sharesPrice("/home/bridgeit/Pranit/Programs/JSONFiles/Shares.json","Price/share");
					
					
					JSONObject oneCustomer = account.customerObject("/home/bridgeit/Pranit/Programs/JSONFiles/CustomersPortfolio.json",accountNo);
					
					JSONArray companyName =  (JSONArray) oneCustomer.get("Share Names");
					JSONArray shareCount = (JSONArray) oneCustomer.get("Share Count");
					
					System.out.println(companyName);
					System.out.println(shareCount);
					
					double total = 0.0;
					
					for(int i=0;i<companyName.size();i++) 
					{
						String sname = (String)companyName.get(i);
						long scount = (long)shareCount.get(i);
						
						for(int j=0;j<sharename.length;j++) 
						{
							if(sname.equals(sharename[j].replaceAll(" ", ""))) 
							{
								total = total+(scount*price[j]);
							}
						}
					}
					System.out.println("your portfolio estimated cost is "+total);
				}
				else 
				{
					System.out.println("Invalid account number");
				}
				
				break;
				
			default:
				System.exit(0);
				
			}
		}
		
	}

}
