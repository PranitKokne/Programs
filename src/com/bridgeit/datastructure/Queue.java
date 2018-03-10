/******************************************************************************
 *  
 *
 *  Purpose:The program behaves as a cash counter in a bank.
 *  		it allows each customer to deposit and withdraw money from his account.
 * 			it also allows a customer to check his balance after transaction and 
 * 			maintain the balance.
 *  
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   06-03-2018
 *
 ******************************************************************************/

package com.bridgeit.datastructure;

import com.bridgeit.utility.Utility;

public class Queue 
{
	/*
	 * main function takes size of the queue and 
	 * the customer details as a input and 
	 * provides each customer the various services such as 
	 * deposit the money withdraw the money and check balance.
	 *  
	 */

	public static void main(String[] args) 
	{
		
		Customer cust = new Customer();
		
		String custName;
		long contactNumber;
		double balance;
		
		Utility util = new Utility();
		
		System.out.print("Enter the size of Queue : ");
		int size = util.integerInput();
		
		
		Customer[] customer = new Customer[size];
	 
		
		System.out.println("Cash Counter");
		
		int numberofCustomers = customer.length;
		int count = 0;
		
		while(numberofCustomers!=0) 
		{
			
			System.out.print("Customer "+(count+1)+" Enter your name : ");
			custName = util.inputString();
			
			System.out.print("Enter your contact number : ");
			contactNumber = util.longInput();
			
			System.out.print("Enter the initial balance : ");
			balance = util.doubleInput();
			
			customer[count]=new Customer(balance,custName,contactNumber);
			
			numberofCustomers--;
			
			count++;
		}
	
		for(int j=0;j<customer.length;j++) 
		{
			System.out.println(customer[j]);
		}
		
		
		for(int j=0;j<customer.length;j++) 
		{
			System.out.println("Services provided by the Bank of America ");
			System.out.println("press 1 for Deposit operation : ");
			System.out.println("press 2 for Withdraw operation : ");
			System.out.println("press 3 to check your account balance");
			System.out.println("press 4 to exit : \n");
			
			boolean flag = true;
			
			while(flag) 
			{
				System.out.println(customer[j].getmCustName()+" enter your choice : ");
				int choice = util.integerInput();
				
				switch(choice) 
				{
				case 1:
					System.out.print("Enter the amount you want to deposit : ");
					double deposit = util.doubleInput();
					System.out.println("balance after deposit operation : "+util.deposit(customer,deposit,j));
					break;
					
				case 2:
					System.out.print("Enter the amount you want to withdraw : ");
					double withdraw = util.doubleInput();
					if(util.withdraw(customer,withdraw,j)>0)
						System.out.println("balance after withdraw operation : "+customer[j].getmInitialBalance());
					else
						System.out.println("Insufficient balance : ");
					break;
					
				case 3:
					System.out.println("Checking balance....");
					System.out.println("your current balance is : "+util.checkBalance(customer,j));
					break;
					
				case 4:
					flag=false;
			}
			
		}
			
		}				
	}
}
