/**
 * Purpose :The program allows a user to open account for trading.it also allows a user
 * 			to buy and sell shares of companies.the user can also see the available shares 
 * 			of companies and it's portfolio's estimated cost.
 * 
 * @author Pranit_Kokne
 * @version 1.0
 * @since 26-03-2018
 *
 */

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
		
		File thirdFile = new File("/home/bridgeit/Pranit/Programs/JSONFiles/CustomersPortfolio.json");
		boolean thirdResult = false;
		
		
		Utility util = new Utility();
		StockAccount account = new StockAccount();
		
		System.out.println("Press 1 to open an account");
		System.out.println("Press 2 to buy shares");
		System.out.println("Press 3 to sell shares");
		System.out.println("Press 4 to see the available shares of companies");
		System.out.println("Press 5 to check the portfolio's value");
		System.out.println("Press any other key to exit");
			
		String name;
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
			
			
			boolean tradeResult = false;
			boolean availableResult = false;
			
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
				System.out.print("Enter the amount for trading : ");
				balance = util.doubleInput();
				System.out.print("Choose an numeric account number : ");
				accountNo = util.longInput();
				
				JSONObject customer = new JSONObject();
				customer.put("Name", name);
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
				try 
				{
					thirdResult = thirdFile.createNewFile();
				}catch(IOException io) 
				{
					io.printStackTrace();
				}
				
				System.out.print("Enter your account number : ");
				accountNo= util.longInput();
				result = StockAccount.authentication(accountNo);
				if(result) 
				{
					System.out.print("Enter the company name whose share you want to buy : ");
					shareName = util.inputString();
					System.out.print("Enter the number of shares you want to buy : ");
					numberofShares = util.longInput();
					//check shares are available for buying....
					availableResult = StockAccount.isAvailable(numberofShares,shareName);
					//System.out.println(availableResult);
					if(availableResult) 
					{
						/*
						 * case 1 : customers portfolio doesn't exist so it's first object just write it to the cp.json file
						 * case 2 : new customer bought shares so write it to the cp.json file
						 * case 3 : update the cp.json on the basis of account number.
						 */
						boolean operationResult;
						if(thirdResult) 
						{
							//write first json object into json array.
							//create a method that will do this job for you
							operationResult = StockAccount.portfolioDoesNotExit(shareName, numberofShares, accountNo,"First");
							if(operationResult)
								tradeResult = StockAccount.buy(shareName, numberofShares, accountNo, "notpresent");
						}
						else 
						{
							//check customer is present in the cp.json file or not
							//if yes then 
							boolean authenticationResult = StockAccount.authenticationofCustomersPortfolio(accountNo);
							if(authenticationResult) 
							{
								tradeResult = StockAccount.buy(shareName,numberofShares,accountNo,"present");
							}
							else 
							{
								operationResult = StockAccount.portfolioDoesNotExit(shareName, numberofShares, accountNo, "Second");
								if(operationResult)
									tradeResult = StockAccount.buy(shareName, numberofShares, accountNo, "notpresent");
							}					
						}
						if(tradeResult)
						{
							System.out.println(shareName+"'s "+numberofShares+" shares are added to your account");
						}
						else
						{
							System.out.println("Error in adding the shares to your account");
						}
					}
					else 
					{
						System.out.println("Insufficient shares...");
					}
				}
				else 
				{
					System.out.println("Invalid account number");
				}
				break;
								
			case 3:
				System.out.print("Enter your account number : ");
				accountNo= util.longInput();
				result = StockAccount.authentication(accountNo);
				if(result) 
				{
					System.out.print("Enter the company name whose share you want to sell : ");
					shareName = util.inputString();
					System.out.print("Enter the number of shares you want to sell : ");
					numberofShares = util.longInput();
					tradeResult = StockAccount.sell(shareName, numberofShares, accountNo);
					if(tradeResult) 
					{
						System.out.println(shareName+"'s "+numberofShares+" shares sold.");
					}
					else 
					{
						System.out.println("Error in selling the shares");
					}
				}
				else 
				{
					System.out.println("Invalid account number");
				}
				break;
				
			case 4:
				System.out.println("over view of comapanies share price");
				account.printReport();
				break;
				
			case 5:
				System.out.print("Enter your account number : ");
				accountNo = util.longInput();
				feedback = StockAccount.authentication(accountNo);
				if(feedback) 
				{
					//portfolio value calculate
					String[] sharename = StockAccount.retrieveString("/home/bridgeit/Pranit/Programs/JSONFiles/Shares.json","Company Name");
					long[] price = StockAccount.retrieveLong("/home/bridgeit/Pranit/Programs/JSONFiles/Shares.json","Price");
					
					
					JSONObject oneCustomer = StockAccount.customerObject("/home/bridgeit/Pranit/Programs/JSONFiles/CustomersPortfolio.json",accountNo);
					
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
