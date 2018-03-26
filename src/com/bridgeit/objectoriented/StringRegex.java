/**
 * Purpose :The program takes user basic information as a input. it replace the target string
 * 			with the basic information with the help of RegEx library and prints the final 
 * 			target string.
 * 
 * @author Pranit_Kokne
 * @version 1.0
 * @since 19-03-2018
 *
 */

package com.bridgeit.objectoriented;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bridgeit.utility.Utility;

public class StringRegex {

	public static void main(String[] args) 
	{
		Utility util = new Utility();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		
		String target = "Hello <<name>>, We have your full name as <<full name>> in our system. "
						+ "your contact number is 91-xxxxxxxxxx. "
						+ "Please,let us know in case of any clarification Thank you BridgeLabz DD/MM/YYYY.";
		
		String[] information = new String[3];
		
		String[] patterns = new String[] {"<<name>>","<<full name>>","xxxxxxxxxx"} ;
		
		System.out.print("Enter your name : ");
		information[0] = util.inputStringLine();
		
		System.out.print("Enter your full name : ");
		information[1] = util.inputStringLine();
		
		System.out.print("Enter your mobile number : ");
		information[2] = util.inputStringLine();
		
		for(int i=0;i<information.length;i++) 
		{
			Pattern pattern = Pattern.compile(patterns[i]);
			Matcher matcher = pattern.matcher(target);
			while(matcher.find()) 
			{
				target=target.replaceAll(patterns[i],information[i]);
			}
		}
		
		Pattern pattern = Pattern.compile("DD/MM/YYYY");
		Matcher matcher = pattern.matcher(target);
		while(matcher.find()) 
		{
			target = target.replaceAll("DD/MM/YYYY", formatter.format(date));
		}
		
		
		System.out.println(target);

	}

}
