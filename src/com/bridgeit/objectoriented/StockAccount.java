package com.bridgeit.objectoriented;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgeit.datastructure.MyQueue;

public class StockAccount 
{
	String name;
	long mobileNumber;
	String emailId;
	double balance;
	long accountNo;

	public StockAccount() 
	{
		
		
	}
	
	public void buy() 
	{
		
	}
	
	public void sell() 
	{
		
	}
	
	public void save() 
	{
		
	}
	//shares is a file we have to pull each object from that json file and we have to print it 
	//in a 2 D from like a table....
	public void printReport() 
	{
		String[][] report = new String[5][3];
		System.out.println("Company  "+"Price "+"Available Shares");
		
		JSONParser parser = new JSONParser();
		
		try 
		{
			JSONArray stock =(JSONArray)parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/Shares.json"));
				
			for(int i=0;i<stock.size();i++) 
			{
					int j = 0;
					JSONObject share = (JSONObject)stock.get(i);
					String companyName =(String) share.get("Company Name");
					report[i][j] = companyName;
					long price =(long)share.get("Price/share");
					report[i][++j] = Long.toString(price);
					long sharesCount = (long) share.get("Available Shares");
					report[i][++j] = Long.toString(sharesCount);
				
			}
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		
		for(int i=0;i<report.length;i++) 
		{
			for(int j=0;j<report[i].length;j++) 
			{
				System.out.print(report[i][j]+"  ");
			}
			System.out.println();
		}
		
		
	}
	
	public void valueOf() 
	{
		
	}
	
	
	public boolean authentication(long accountNo) 
	{
		JSONParser parser = new JSONParser();
		
		try 
		{
			JSONArray custArray =(JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/Customers.json"));
			
			for(int i=0;i<custArray.size();i++) 
			{
				JSONObject customer = (JSONObject)custArray.get(i);
				if(accountNo == (long)customer.get("Account Number")) 
				{
					return true;
				}
			}
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		
		return false;
	}
	
	public boolean deleteObject(JSONArray customersPortfolio, long accountNo) 
	{
		System.out.println(customersPortfolio.size());
		for(int i=0;i<customersPortfolio.size();i++) 
		{
			JSONObject customerDetails = (JSONObject) customersPortfolio.get(i);
			if((long)customerDetails.get("Account Number") == accountNo )
			{
				customersPortfolio.remove(i);
				return true;
			}
		}
		return false;
	}
	

}
