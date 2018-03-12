/**
 * Purpose :The program read a text from a file and split them into words 
 * 			later it stores the words into linked list. then it searches
 * 			the word entered by the user is present in the list or not.
 * 			if yes then it removes that word from a list else insert that 
 * 			word into the list.
 *  
 * @author Pranit_Kokne
 * @version 1.0
 * @since 10-03-2018
 *
 */

package com.bridgeit.datastructure;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import com.bridgeit.utility.Utility;

public class UnorderedList {

	/**
	 * the main function reads the word from a file and add it to the linked list
	 * later it search the word entered by the user is present in the list or not. 
	 * if yes the it removes that word else add that word into the list and update 
	 * the file with the changes. 
	 * 
	 */
	public static void main(String[] args) {
		
		Utility util = new Utility();
		
		String empty = "";
		
		MyLinkedList<String> words = new MyLinkedList<String>();
		
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
		
		Utility.fileWriting("/home/bridgeit/Pranit/files/words.text", words);
		
				
		

	}

}
