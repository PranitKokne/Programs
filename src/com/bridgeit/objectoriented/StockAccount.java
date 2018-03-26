package com.bridgeit.objectoriented;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgeit.datastructure.MyQueue;

public class StockAccount 
{
	String name;
	long mobileNumber;
	String emailId;
	double balance;
	long accountNo;

	
	//shares is a file we have to pull each object from that json file and we have to print it 
	//in a 2 D from like a table....
	/**
	 * the method print the portfolio cost for a particular customer
	 */
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
					long price =(long)share.get("Price");
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/***********************object modifications all methods***********************************/
	
	
	public static boolean fileWritingInJSON(String path,JSONArray object) 
	{
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
		fileWriter = new FileWriter(path);
		bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(object.toJSONString());
		return true;
		}catch(IOException io) 
		{
			io.printStackTrace();
		}
		finally 
		{
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public static boolean fileReadingInJSON(String path,JSONObject object) 
	{
		
		JSONParser parser = new JSONParser();
		
		try 
		{
			Object obj = parser.parse(new FileReader(path));
			
			JSONArray jsonArray = (JSONArray) obj;
			
			jsonArray.add(object);			
			fileWritingInJSON(path,jsonArray);		
			return true;
		
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		return false;
	}
	
	
	public static long[] retrieveLong(String path,String name) 
	{
		JSONParser parser = new JSONParser();
		try
		{
			JSONArray jsonArray = (JSONArray)parser.parse(new FileReader(path));
			long[] value = new long[jsonArray.size()];
			
			for(int i=0;i<jsonArray.size();i++) 
			{
				JSONObject jsonObject = (JSONObject)jsonArray.get(i);
				value[i] = (long) jsonObject.get(name);	
			}
			return value;
		
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		return null;
	}

	public static String[] retrieveString(String path,String name) 
	{
		JSONParser parser = new JSONParser();
		try
		{
			JSONArray jsonArray = (JSONArray)parser.parse(new FileReader(path));
			String[] stringArray = new String[jsonArray.size()];
			
			for(int i=0;i<jsonArray.size();i++) 
			{
				JSONObject share = (JSONObject)jsonArray.get(i);
				stringArray[i] = (String)share.get(name);
			}
			return stringArray;
		
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		return null;
	}

	public static double[] retrieveDouble(String path,String name) 
	{
		JSONParser parser = new JSONParser();
		try
		{
			JSONArray jsonArray = (JSONArray)parser.parse(new FileReader(path));
			double[] value = new double[jsonArray.size()];
			
			for(int i=0;i<jsonArray.size();i++) 
			{
				JSONObject jsonObject = (JSONObject)jsonArray.get(i);
				value[i] = (double) jsonObject.get(name);	
			}
			return value;
		
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		return null;
	}

	public static String[][] retrieveString2DArray(String path,String name)
	{
		JSONParser parser = new JSONParser();
		
		try
		{
			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(path));
			String[][] valueArray = new String[jsonArray.size()][];
			for(int i=0;i<jsonArray.size();i++) 
			{
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				JSONArray count =   (JSONArray) jsonObject.get(name);
				valueArray[i] = new String[count.size()];
				for(int j=0;j<count.size();j++) 
				{
					valueArray[i][j] = (String) count.get(j);
				}
			}
			return valueArray;
			
		} 
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static long[][] retrieveLong2DArray(String path,String name)
	{
		JSONParser parser = new JSONParser();
		
		try
		{
			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(path));
			long[][] valueArray = new long[jsonArray.size()][];
			for(int i=0;i<jsonArray.size();i++) 
			{
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				JSONArray count =   (JSONArray) jsonObject.get(name);
				
				valueArray[i] = new long[count.size()];
				for(int j=0;j<count.size();j++) 
				{
					valueArray[i][j] = (long) count.get(j);
				}
			}
			return valueArray;
			
		} 
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

		
	
	public static JSONObject customerObject(String path,long accountNo) 
	{
		JSONParser parser = new JSONParser();
		try
		{
			JSONArray customers = (JSONArray)parser.parse(new FileReader(path));
			for(int i=0;i<customers.size();i++) 
			{
				JSONObject customer = (JSONObject)customers.get(i);
				if((long)customer.get("Account Number") == accountNo) 
				{
					return customer;
				}
			}
			
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		return null;
	}


	
	/**
	 *the method verifies the account number entered by the user is valid or not.
	 * @param accountNo entered by the user.
	 * @return true if the account number is valid else false.
	 */
	public static boolean authentication(long accountNo) 
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
	/**
	 *the method verifies the account number entered by the user is valid or not.
	 * @param accountNo entered by the user.
	 * @return true if the account number is valid else false.
	 */
	public static boolean authenticationofCustomersPortfolio(long accountNo) 
	{
		JSONParser parser = new JSONParser();
		
		try 
		{
			JSONArray custArray =(JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/CustomersPortfolio.json"));
			
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
	
	
	/**
	 * the method checks whether the company has enough share in the market or not
	 * so that the customer can bought it.
	 * 
	 * @param numberofShares the user want
	 * @param shareName the name of the share the user want to buy
	 * @return true if the enough shares are available else false.
	 */
	public static boolean isAvailable(long numberofShares, String shareName) 
	{
		JSONParser parser = new JSONParser();
		
		try 
		{
			JSONArray shares = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/Shares.json"));
			
			for(int i=0;i<shares.size();i++) 
			{
				JSONObject oneShare = (JSONObject) shares.get(i);
				String sname = (String) oneShare.get("Company Name");
				sname = sname.replaceAll(" ", "");
				
				
				if(shareName.equals(sname)) 
				{
					long availableShares = (long) (oneShare.get("Available Shares"));
					if(availableShares>=numberofShares)
						return true;
				}
			
			}
		} 
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * the method checks whether the user has sufficient balance or not
	 * so that he can buy the shares.
	 * 
	 * @param shareName
	 * @param numberofShares
	 * @param accountNo
	 * @return true if the sufficient balance is available else false
	 */
	public static boolean isEnoughBalance(String shareName,long numberofShares,long accountNo) 
	{
		String[] sharename = retrieveString("/home/bridgeit/Pranit/Programs/JSONFiles/Shares.json","Company Name");
		long[] price = retrieveLong("/home/bridgeit/Pranit/Programs/JSONFiles/Shares.json","Price");

		JSONObject custBalance = customerObject("/home/bridgeit/Pranit/Programs/JSONFiles/Customers.json",accountNo);
		
		double currentBalance = (double) custBalance.get("Balance");
		
		for(int i=0;i<sharename.length;i++) 
		{
			if(shareName.equals(sharename[i].replaceAll(" ", ""))) 
			{
				if((price[i]*numberofShares)<=currentBalance) 
				{
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * the method updates the shares count when a customer buys a share or sells a share
	 * 
	 * @param shareName
	 * @param numberofShares
	 * @return
	 */
	public static boolean updateShareCount(String shareName,long numberofShares,String trade) 
	{
		JSONParser parser = new JSONParser();
		
		try 
		{
			JSONArray stocks = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/Shares.json"));
			
			for(int i=0;i<stocks.size();i++) 
			{
				boolean result;
				JSONObject company = (JSONObject) stocks.get(i);
				String sname = (String) company.get("Company Name");
				sname = sname.replaceAll(" ", "");
				if(sname.equals(shareName)) 
				{
					long shareCount = (long) company.get("Available Shares");
			
						if(trade.equals("buy")) 
						{
							if(shareCount - numberofShares >= 0)
							{
								shareCount = shareCount - numberofShares;
							}							
						}
						else if(trade.equals("sell")) 
						{
							if(shareCount + numberofShares <=200)
							{
								shareCount = shareCount + numberofShares;
							}
							else 
							{
								return false;
							}
						}
						result = writeSameObjectIntoShares(shareName,shareCount);
						if(result) 
						{
							return true;
						}
				}
				
			}
		} 
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static boolean writeSameObjectIntoShares(String shareName,long shareCount) 
	{
		long[] price = retrieveLong("/home/bridgeit/Pranit/Programs/JSONFiles/Shares.json","Price");
		String[] sharename = retrieveString("/home/bridgeit/Pranit/Programs/JSONFiles/Shares.json","Company Name");
		long[] availableShares = retrieveLong("/home/bridgeit/Pranit/Programs/JSONFiles/Shares.json","Available Shares");
			
		JSONArray stocks = new JSONArray();
		JSONParser parser = new JSONParser();
		
		try 
		{
			JSONArray shares = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/Shares.json"));
			
			for(int i=0;i<shares.size();i++) 
			{
				JSONObject share = new JSONObject();
				JSONObject oneShare = (JSONObject) shares.get(i);
				String sname = (String) oneShare.get("Company Name");
				sname = sname.replaceAll(" ", "");
				
				if(shareName.equals(sname)) 
				{
					share.put("Company Name", shareName);
					share.put("Available Shares",shareCount);
					share.put("Price", price[i]);
					stocks.add(i, share);
				}
				else 
				{
					share.put("Company Name", sharename[i]);
					share.put("Available Shares",availableShares[i]);
					share.put("Price", price[i]);
					stocks.add(i, share);
				}
				fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/Shares.json",stocks);
			}
			
			return true;
		} 
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean writeSameObjectIntoCustomers(long accountNo,double updatedBalance) 
	{
		long[] accountNumber = retrieveLong("/home/bridgeit/Pranit/Programs/JSONFiles/Customers.json","Account Number");
		String[] custName = retrieveString("/home/bridgeit/Pranit/Programs/JSONFiles/Customers.json","Name");
		double[] balance = retrieveDouble("/home/bridgeit/Pranit/Programs/JSONFiles/Customers.json","Balance");
		
				
		
				
		JSONParser parser = new JSONParser();
		JSONArray person = new JSONArray();
		try 
		{
			JSONArray customers = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/Customers.json"));
			
			for(int i=0;i<customers.size();i++) 
			{
				JSONObject onePerson = new JSONObject();
				JSONObject oneCustomer = (JSONObject) customers.get(i);
				long accNo =  (long) oneCustomer.get("Account Number");
				
				if(accountNo == accNo) 
				{
					onePerson.put("Account Number", accountNumber[i]);
					onePerson.put("Balance",updatedBalance);
					onePerson.put("Name", custName[i]);
					person.add(i, onePerson);
				}
				else 
				{
					onePerson.put("Account Number", accountNumber[i]);
					onePerson.put("Balance",balance[i]);
					onePerson.put("Name", custName[i]);
					person.add(i, onePerson);
				}
				fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/Customers.json",person);
			}
			
			return true;
		} 
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	
	/*
	 * 1.Check User has sufficient balance or not if yes then only proceed further Customer.json done
	 * 2.Decrease the company's share count Shares.json
	 * 3.add the shares to the Portfolio.json
	 * 4.decrease the balance of customer Customers.json
	 * 5.then only return true
	 */
	
	/**
	 * buys the shares of a particular company for a customer
	 * 
	 * @param shareName the company name whose share the customer wants to buy
	 * @param numberofShares the customer want to buy
	 * @param accountNo of the customer
	 * @param type it is used to check whether the customers is already present in 
	 * 		  the customers portfolio file or not
	 * @return true if the buy operation is successful else false
	 */
	public static boolean buy(String shareName,long numberofShares,long accountNo,String type) 
	{
		//checking balance
		if(isEnoughBalance(shareName,numberofShares,accountNo)) 
		{
			//step 2
			if(updateShareCount(shareName,numberofShares,"buy")) 
			{
				if(updateBalanceOfCustomer(shareName,numberofShares,accountNo,"buy")) 
				{
					if("present".equals(type)) 
					{
						if(updateCustomersPortfolioWhileBuying(shareName,numberofShares,accountNo)) 
						{
							return true;
						}
					}
					else 
					{
						return true;
					}
				}
			}
			else 
			{
				System.out.println("Not enough shares are available to buy");
			}
		}
		else 
		{
			System.out.println("Insufficient Balance");
		}
		return false;
	}
	
	/**
	 *sells the shares of a particular company for a customer
	 * 
	 * @param shareName the company whose share the customer want to sell
	 * @param numberofShares the customer want to sell
	 * @param accountNo of the customer
	 * @return true if the sell operation is successful else false
	 */
	public static boolean sell(String shareName,long numberofShares,long accountNo) 
	{
		if(updateShareCount(shareName,numberofShares,"sell")) 
		{
			if(updateCustomersPortfolioWhileSelling(shareName,numberofShares,accountNo)) 
			{
				if(updateBalanceOfCustomer(shareName,numberofShares,accountNo,"sell")) 
				{
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	
	public static boolean updateBalanceOfCustomer(String shareName,long numberofShares,long accountNo,String trade) 
	{
		double updatedBalance = changeBalanceOfCustomer(shareName,numberofShares,accountNo,trade);
		
		boolean result = writeSameObjectIntoCustomers(accountNo,updatedBalance);
		
		if(result) 
		{
			return true;
		}
		return false;
	}
	
	
	public static double changeBalanceOfCustomer(String shareName,long numberofShares,long accountNo,String trade) 
	{
		JSONParser parser = new JSONParser();
		try 
		{
			JSONArray customers = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/Customers.json"));
			JSONArray stock = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/Shares.json"));
			for(int i=0;i<customers.size();i++) 
			{
				
				JSONObject person = (JSONObject) customers.get(i);
				long accNo =  (long) person.get("Account Number");

				if(accNo == accountNo) 
				{
					double balance = (double) person.get("Balance");
					long sprice = 0 ;
					for(int j=0;j<stock.size();j++) 
					{
						JSONObject share = (JSONObject) stock.get(j);
						String sname = (String) share.get("Company Name");
						sname = sname.replaceAll(" ", "");
						
						if(shareName.equals(sname)) 
						{
							sprice = (long) share.get("Price");
						}
					}
					if(trade.equals("buy")) 
					{
						balance = balance - (numberofShares*sprice);
					}
					else if(trade.equals("sell")) 
					{
						balance = balance + (numberofShares*sprice);
					}
					return balance;
				}
			}
		} 
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}
	
		return 0.0;
	}
	
	public static boolean updateCustomersPortfolioWhileBuying(String shareName,long numberofShares,long accountNo) 
	{
		boolean flag = false;
		long[] accountNumber = retrieveLong("/home/bridgeit/Pranit/Programs/JSONFiles/CustomersPortfolio.json","Account Number");
		long[][] sharecount = retrieveLong2DArray("/home/bridgeit/Pranit/Programs/JSONFiles/CustomersPortfolio.json","Share Count");
		String[][] sharename = retrieveString2DArray("/home/bridgeit/Pranit/Programs/JSONFiles/CustomersPortfolio.json","Share Names");
		
		JSONParser parser = new JSONParser();
		JSONArray updatedPortfolio = new JSONArray();
		try
		{
			JSONArray portfolio = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/CustomersPortfolio.json"));
			for(int i=0;i<portfolio.size();i++) 
			{
				JSONObject oneCustPortfolio = (JSONObject) portfolio.get(i);
				
				JSONObject updatedOneCustPortfolio = new JSONObject();
				
				JSONArray updatedShareName = new JSONArray();
				JSONArray increaseShareCount = new JSONArray();
				
				String[] oneCustShares; long[] oneCustShareCount;
				
				long accNo =(long) oneCustPortfolio.get("Account Number");
				
				if(accNo == accountNo) 
				{
					
					oneCustShares = sharename[i];
					oneCustShareCount = sharecount[i];
					for(int l=0;l<oneCustShares.length;l++) 
					{
						if(shareName.equals(oneCustShares[l])) 
						{
							flag = true;
						}
					}
					if(flag) 
					{
						for(int c=0;c<oneCustShares.length;c++) 
						{
							if(shareName.equals(oneCustShares[c])) 
							{
								long changeCount = oneCustShareCount[c] + numberofShares;
								increaseShareCount.add(changeCount);
							}
							else 
							{
								increaseShareCount.add(oneCustShareCount[c]);
							}
							updatedShareName.add(oneCustShares[c]);
						}
					}
					else
					{
						oneCustShares = sharename[i];
						oneCustShareCount = sharecount[i];
						for(int n=0;n<oneCustShares.length;n++) 
						{
							updatedShareName.add(oneCustShares[n]);
							increaseShareCount.add(oneCustShareCount[n]);
						}
						updatedShareName.add(shareName);
						increaseShareCount.add(numberofShares);
					}
					updatedOneCustPortfolio.put("Account Number", accountNumber[i]);
					updatedOneCustPortfolio.put("Share Names", updatedShareName);					
					updatedOneCustPortfolio.put("Share Count", increaseShareCount);
				}
				else 
				{
					updatedOneCustPortfolio.put("Account Number", accountNumber[i]);
					for(int a=0;a<sharename[i].length;a++) 
					{
						updatedShareName.add(sharename[i][a]);
					}
					updatedOneCustPortfolio.put("Share Names", updatedShareName);
					for(int b=0;b<sharecount[i].length;b++) 
					{
						increaseShareCount.add(sharecount[i][b]);
					}
					updatedOneCustPortfolio.put("Share Count", increaseShareCount);
				}
				updatedPortfolio.add(updatedOneCustPortfolio);
			}
			fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/CustomersPortfolio.json",updatedPortfolio);
			return true;
			
		} 
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean portfolioDoesNotExit(String shareName,long numberofShares,long accountNo,String type) 
	{
		JSONArray portfolio = new JSONArray();
		
		JSONObject firstCustomer = new JSONObject();
		JSONArray sharecount = new JSONArray();
		JSONArray sharename = new JSONArray();
		firstCustomer.put("Account Number", accountNo);
		sharename.add(shareName);
		firstCustomer.put("Share Names", sharename);
		sharecount.add(numberofShares);
		firstCustomer.put("Share Count", sharecount);
		
		boolean result;
		if(type.equals("First")) 
		{
			portfolio.add(firstCustomer);
			result = fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/CustomersPortfolio.json",portfolio);
			if(result) 
			{
				return true;
			}
		}
		else if(type.equals("Second"))
		{
			result = fileReadingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/CustomersPortfolio.json",firstCustomer);
			if(result) 
			{
				return true;
			}
				
		}
		return false;
	}

	
	public static boolean updateCustomersPortfolioWhileSelling(String shareName,long numberofShares,long accountNo) 
	{
		long[] accountNumber = retrieveLong("/home/bridgeit/Pranit/Programs/JSONFiles/CustomersPortfolio.json","Account Number");
		long[][] sharecount = retrieveLong2DArray("/home/bridgeit/Pranit/Programs/JSONFiles/CustomersPortfolio.json","Share Count");
		String[][] sharename = retrieveString2DArray("/home/bridgeit/Pranit/Programs/JSONFiles/CustomersPortfolio.json","Share Names");
		
		JSONParser parser = new JSONParser();
		JSONArray updatedPortfolio = new JSONArray();
		try
		{
			JSONArray portfolio = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/CustomersPortfolio.json"));
			for(int i=0;i<portfolio.size();i++) 
			{
				JSONObject oneCustPortfolio = (JSONObject) portfolio.get(i);
				
				JSONObject updatedOneCustPortfolio = new JSONObject();
				
				JSONArray updatedShareName = new JSONArray();
				JSONArray increaseShareCount = new JSONArray();
				
				String[] oneCustShares; long[] oneCustShareCount;
				
				long accNo =(long) oneCustPortfolio.get("Account Number");
				
				if(accNo == accountNo) 
				{
					updatedOneCustPortfolio.put("Account Number", accountNo);
					oneCustShares = sharename[i];
					oneCustShareCount = sharecount[i];
					
					for(int d=0;d<oneCustShares.length;d++) 
					{
						if(shareName.equals(oneCustShares[d])) 
						{
							if(oneCustShareCount[d]>=numberofShares) 
							{
								long shareCount = oneCustShareCount[d] - numberofShares;
								if(shareCount!=0) 
								{
									updatedShareName.add(oneCustShares[d]);
									increaseShareCount.add(shareCount);
								}
							}
							else 
							{
								System.out.println("Insufficient shares");
								return false;
							}
						}
						else 
						{
							updatedShareName.add(oneCustShares[d]);
							increaseShareCount.add(oneCustShareCount[d]);
						}
					}
					updatedOneCustPortfolio.put("Share Names", updatedShareName);
					updatedOneCustPortfolio.put("Share Count", increaseShareCount);
				}
				else 
				{
					updatedOneCustPortfolio.put("Account Number", accountNumber[i]);
					for(int a=0;a<sharename[i].length;a++) 
					{
						updatedShareName.add(sharename[i][a]);
					}
					updatedOneCustPortfolio.put("Share Names", updatedShareName);
					for(int b=0;b<sharecount[i].length;b++) 
					{
						increaseShareCount.add(sharecount[i][b]);
					}
					updatedOneCustPortfolio.put("Share Count", increaseShareCount);
				}
				updatedPortfolio.add(updatedOneCustPortfolio);
			}
			fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/CustomersPortfolio.json",updatedPortfolio);
			return true;
			
		} 
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	

}
