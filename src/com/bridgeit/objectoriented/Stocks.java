/**
 * Purpose :The program takes the number of stocks,share names,price of each share
 * 			and number of each share as a input and prints the stock report 
 * 			consisting the value of each share and total value of stock.
 *  
 * @author Pranit_Kokne
 * @version 1.0
 * @since 21-03-2018
 *
 */

package com.bridgeit.objectoriented;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.bridgeit.utility.Utility;

public class Stocks {
	
	/**
	 * the function writes the JSON array into a file.
	 * 
	 * @param path of the file
	 * @param array JSON array
	 * @return true if the operation is successful else false
	 */
	public static boolean fileWritingInJSON(String path,JSONArray array) 
	{
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
		fileWriter = new FileWriter(path);
		bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(array.toJSONString());
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
	
	/**
	 * the function calculates the value of each share 
	 * and total value of the stocks and prints the estimated 
	 * value.
	 * @param count number of stocks
	 */
	public static void stockEvalution(int count) 
	{
		double[] totalValue = new double[count];
		double totalWorth = 0.0;
	
		JSONParser parser = new JSONParser();
	
		try 
		{
			Object obj = parser.parse(new FileReader( "/home/bridgeit/Pranit/Programs/JSONFiles/Stocks.json"));
			
			JSONArray jsonArray = (JSONArray) obj;
			
			for(int i=0;i<count;i++) 
			{
				JSONObject object =(JSONObject) (jsonArray.get(i));
				
				double value = (double)object.get("Share Price")*(long)object.get("Number of Shares");
				System.out.println("The value of "+object.get("Share Name")+" share is "+value);
				totalValue[i] = value;
			}
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		for(double value : totalValue) 
		{
			totalWorth+=value;
		}
		
		System.out.println("Total estimated value of your portfolio is : "+totalWorth);
	}

	/**
	 * the main function takes the number of shares its name,value as a input
	 * and writes it to the JSON file and prints the entire portfolio. 
	 */
	public static void main(String[] args) {
		
		Utility util = new Utility();
		
		System.out.print("Enter the number of Stocks you have : ");
		int count = util.integerInput();
		
		JSONArray array = new JSONArray();
		
		
		for(int i=1;i<=count;i++) 
		{
			JSONObject object = new JSONObject();
			System.out.print("Enter the "+i+" Share name : ");
			String shareName = util.inputString();
			System.out.print("Enter the "+shareName+ "'s number of shares : ");
			int noofShares = util.integerInput();
			System.out.print("Enter the price of "+shareName+ " each share : ");
			double sharePrice = util.doubleInput();
			
			object.put("Share Name", shareName);
			object.put("Number of Shares", noofShares);
			object.put("Share Price", sharePrice);
			
			array.add(object);
			

		}
		fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/Stocks.json",array);
		stockEvalution(count);
	}

}
