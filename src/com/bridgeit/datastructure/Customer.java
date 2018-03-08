/******************************************************************************
 *  
 *
 *  Purpose:It is a simple plain old java object class of Customer.
 *
 *  @author  Pranit_Kokne
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/

package com.bridgeit.datastructure;

public class Customer 
{
	/*
	 * mInitialBalance variable stores the initial balance entered by the customer
	 */
	private double mInitialBalance;
	/*
	 * mCustName variable stores the name entered by the customer
	 */
	private String mCustName;
	/*
	 * mContactNumber variable stores the contact number entered by customer
	 */
	 private long mContactNumber;
	
	 /*
	  * default constructor for safety
	  */
		public Customer() 
		{
			
		}
		
	 /**
		 * Constructor to perform the initialization of customer
		 * 
		 * @param mInitialBalance the initial balance of the customer
		 * @param mCustName the name of customer
		 * @param mContactNumber the contact number of customer
		 */

		public Customer(double mInitialBalance, String mCustName, long mContactNumber) {
			super();
			this.mInitialBalance = mInitialBalance;
			this.mCustName = mCustName;
			this.mContactNumber = mContactNumber;
		}

	 

		/*
		 *  
		 * 
		 */
	public double getmInitialBalance() {
		return mInitialBalance;
	}

	public void setmInitialBalance(double mInitialBalance) {
		this.mInitialBalance = mInitialBalance;
	}

	public String getmCustName() {
		return mCustName;
	}

	public void setmCustName(String mCustName) {
		this.mCustName = mCustName;
	}

	public long getmContactNumber() {
		return mContactNumber;
	}

	public void setmContactNumber(long mContactNumber) {
		this.mContactNumber = mContactNumber;
	}
	

	/**
	 * the function is overridden to print the details 
	 * related to the customer
	 * 
	 * @return the information related to the customer 
	 */
	@Override
	public String toString() {
		return "Customer [mInitialBalance=" + mInitialBalance + ", mCustName=" + mCustName + ", mContactNumber="
				+ mContactNumber + "]";
	}

	
	
	

}
