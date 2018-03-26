package com.bridgeit.algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.bridgeit.utility.Utility;

public class FindWordFromWordList {

	public static void main(String[] args) 
	{
		Utility util = new Utility();
		
		String line = null;
		String[] words = null;
		try 
		{
			FileReader fileReader = new FileReader("/home/bridgeit/Pranit/files/wordlist.text");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((line=bufferedReader.readLine())!=null) 
			{
				words = line.split(",");
			}
			bufferedReader.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		//printing the word list containing words
		for(String word : words) 
		{
			System.out.print(word+" ");
		}
		System.out.println();
		
		Utility.insertionSorting(words, words.length);
		
		//asking user for input
		System.out.print("Enter a word for searching : ");
		String searchWord = util.inputString();
		
		int index = Utility.binarySearchForString(words, words.length, searchWord);
		if(index>=0) 
		{
			System.out.println("The word is present at "+index+" index position ");
			System.out.println("here is your word "+words[index]);
		}
		else 
		{
			System.out.println("The word is not present is the sorted list");
		}
	}

}
