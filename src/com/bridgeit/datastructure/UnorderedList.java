/**
 * Purpose :The program read a text from a file and split them into words 
 * 			later it stores the words into linked list. then it searches
 * 			the word entered by the user in present in the list or not.
 * 			if yes then it removes that word from a list else insert that 
 * 			word into the list.
 *  
 * @author Pranit_Kokne
 * @version 1.0
 * @since 10-03-2018
 *
 */

package com.bridgeit.datastructure;

import java.io.FileInputStream;
import java.io.IOException;
import com.bridgeit.utility.Utility;

public class UnorderedList {

	public static void main(String[] args) {
		
		Utility util = new Utility();
		String empty = "";
		MyLinkedList<String> words = new MyLinkedList<String>();
		
		/*FileInputStream fileInputStream = null;
		
		try 
		{
			fileInputStream = new FileInputStream("/home/bridgeit/Pranit/files/names.text");
			
			int data = fileInputStream.read();
			while(data != -1) 
			{
				if(data != ' ') 
				{
					empty=empty+(char)data;
				}
				else 
				{
					words.add(empty);
					empty="";
				}
				data=fileInputStream.read();
			}
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				fileInputStream.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
*/
		
		Utility.fileReading("/home/bridgeit/Pranit/files/words.text", words);
		words.show();
		System.out.print("Enter a word : ");
		String word = util.inputString();
		
		boolean result = words.search(word);
		System.out.println(result);
		if(result) 
		{
			words.deleteByValue(word);
		}
		else 
		{
			words.add(word);
		}
		words.show();
		
		
		System.out.println(words.size());
		

	}

}
