package com.bridgeit.objectoriented;

import java.io.File;

import com.bridgeit.utility.Utility;

public class CliniqueManagement {

	public static void main(String[] args) 
	{
		Utility util = new Utility();
		
		
		System.out.println("Press 1 to search doctor by name");
		System.out.println("Press 2 to search doctor by id");
		System.out.println("Press 3 to search doctor by specialization");
		System.out.println("Press 4 to search doctor by availability");
		System.out.println("Press 5 to take an appointment with the doctor");
		System.out.println("Press 6 to print the doctor patient report");
		System.out.println("Press 7 to check the popular specialization is popular");
		System.out.println("Press 8 to check the most popular doctor of the clinique");
		
		String doctorName; int doctorId; String specialization; String time;
		boolean flag = true;
		boolean result;
		while(flag) 
		{
			System.out.print("Enter your choice : ");
			int choice = util.integerInput();
			util.inputStringLine();
			switch(choice) 
			{
			case 1 : 
				System.out.print("Enter the name of the doctor for searching : ");
				doctorName = util.inputStringLine();
				CliniqueManagementImplementation.searchDoctorByName(doctorName);
				break;
				
			case 2 : 
				System.out.print("Enter the id of the doctor for searching : ");
				doctorId = util.integerInput();
				if(doctorId<=8) 
				{
					CliniqueManagementImplementation.searchDoctorById(doctorId);
				}
				else 
				{
					System.out.println("Invalid Id");
				}
				break;
				
			case 3 :
				System.out.print("Enter the doctor's specialization for searching : ");
				specialization = util.inputString();
				CliniqueManagementImplementation.searchDoctorBySpecialization(specialization);
				break;
				
			case 4 :
				System.out.println("Press A for morning");
				System.out.println("Press P for evening");
				System.out.println("Press B for morning/evening");
				time = util.inputString();
				
				if("A".equals(time)) 
				{
					CliniqueManagementImplementation.searchDoctorByAvailability("AM");
				}
				else if("P".equals(time)) 
				{
					CliniqueManagementImplementation.searchDoctorByAvailability("PM");
				}
				else 
				{
					CliniqueManagementImplementation.searchDoctorByAvailability("Both");
				}
				break;
				
			case 5 : 
				System.out.print("Enter patient name : ");
				String patientName = util.inputStringLine();
				System.out.print("Enter the doctor's name whose appointment you want : ");
				doctorName = util.inputStringLine();
				result = CliniqueManagementImplementation.isAppointmentAvailable(doctorName, patientName,"firstTry");
				if(result) 
				{
					System.out.println(patientName+" your appointment is fixed.");
				}
				else 
				{
					System.out.println("The doctor is booked for today.");
					System.out.println("Would you like to choose another day for appointment");
					System.out.println("Please enter yes or no");
					String response = util.inputString();
					if(response.equals("yes")) 
					{
						result = CliniqueManagementImplementation.isAppointmentAvailable(doctorName, patientName,"!firstTry");
						if(result) 
						{
							
						}
					}
					else 
					{
						System.out.println("Sorry for the inconvenience");
					}
				}
				//call method and check doctor appointment quota is full or not
				//if full then the patient can take appointment at different date or availability time
				//else fix appointment for that particular day.
				break;
				
			case 6 : 
				break;
				
			case 7 : 
				break;
				
			case 8 : 
				break;
				
			default : 
				flag = false;
				System.exit(0);
			}
			
		}
		
		

	}

}
