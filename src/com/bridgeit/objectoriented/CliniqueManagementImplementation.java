package com.bridgeit.objectoriented;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgeit.utility.Utility;

public class CliniqueManagementImplementation 
{
	 
	
	
	public static void searchDoctorByName(String doctorName) 
	{
		JSONParser parser = new JSONParser();
		
		try 
		{
			JSONArray doctors = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/Doctors.json"));
			
			for(int i=0;i<doctors.size();i++) 
			{
				JSONObject oneDoctor = (JSONObject) doctors.get(i);
				if(doctorName.equals((String)oneDoctor.get("Name"))) 
				{
					printInformationOfDoctor(oneDoctor);
				}	
			}
		} 
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void searchDoctorById(int doctorId) 
	{
		JSONParser parser = new JSONParser();
		
		try 
		{
			JSONArray doctors = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/Doctors.json"));
			
			for(int i=0;i<doctors.size();i++) 
			{
				JSONObject oneDoctor = (JSONObject) doctors.get(i);
				if(doctorId == (long)oneDoctor.get("ID")) 
				{
					printInformationOfDoctor(oneDoctor);
				}	
			}
		} 
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void searchDoctorBySpecialization(String specialization) 
	{
		JSONParser parser = new JSONParser();
		
		try 
		{
			JSONArray doctors = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/Doctors.json"));
			
			for(int i=0;i<doctors.size();i++) 
			{
				JSONObject oneDoctor = (JSONObject) doctors.get(i);
				if(specialization.equals((String)oneDoctor.get("Specialization"))) 
				{
					printInformationOfDoctor(oneDoctor);
				}	
			}
		} 
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void searchDoctorByAvailability(String time) 
	{
		JSONParser parser = new JSONParser();
		
		try 
		{
			JSONArray doctors = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/Doctors.json"));
			
			for(int i=0;i<doctors.size();i++) 
			{
				JSONObject oneDoctor = (JSONObject) doctors.get(i);
				if(time.equals((String)oneDoctor.get("Availability"))) 
				{
					printInformationOfDoctor(oneDoctor);
				}	
			}
		} 
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void printInformationOfDoctor(JSONObject doctor) 
	{
		System.out.println("Name : "+(String)(doctor.get("Name")));
		System.out.println("ID : "+(long)(doctor.get("ID")));
		System.out.println("Specialization : "+(String)(doctor.get("Specialization")));
		if("AM".equals((String)(doctor.get("Availability"))))
		{
			System.out.println("Availability Time : "+(String)(doctor.get("Time"))+" AM");
			
		}
		else if("PM".equals((String)(doctor.get("Availability"))))
		{
			System.out.println("Availability Time : "+(String)(doctor.get("Time"))+" PM");
		}
		else 
		{
			System.out.println("Availability Time : "+(String)(doctor.get("Time"))+" AM/PM");
		}
		System.out.println();
	}
	
	
	public static boolean isAppointmentAvailable(String doctorName,String patientName,String type) 
	{
		File file = new File("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/Appointment.json");
		boolean fileCreationResult = false;
		
		try {
			fileCreationResult = file.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//this 2 are related to appointment.json
		JSONArray appointments = new JSONArray();
		JSONObject oneAppointment = new JSONObject();
		
		//this 2 are related to appointmentCount.json
		JSONArray updatedAppointmentCount = new JSONArray();
		JSONObject updatedAppPossible = new JSONObject();
		
		JSONParser parser = new JSONParser();
		
		try 
		{	
			long updatedCount ;
			JSONArray appointmentCount = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointmentCount.json"));
			JSONObject appPossible = new JSONObject();
			for(int i=0;i<appointmentCount.size();i++) 
			{
				appPossible = (JSONObject) appointmentCount.get(i);
				if(doctorName.equals((String)(appPossible.get("Name"))))
				{
					if("AM".equals((String)appPossible.get("Availability"))) 
					{
						if((long)appPossible.get("morning count")>0) 
						{
							//fix appointment
							oneAppointment.put("Doctor Name", doctorName);
							oneAppointment.put("Patient Name", patientName);
							oneAppointment.put("Date", getDate());
							//count decrease
							
							updatedCount = (long) appPossible.get("morning count");
							updatedAppPossible.put("morning count", (updatedCount-1));
						}
						else 
						{
							//count assign to 5 again
							updatedAppPossible.put("morning count", 5);
							return false;
						}
						updatedAppPossible.put("Name", (String)(appPossible.get("Name")));
						updatedAppPossible.put("Name", (String)(appPossible.get("Availability")));
					}
					else if("PM".equals((String)appPossible.get("Availability"))) 
					{
						if((long)appPossible.get("evening count")>0) 
						{
							//fix appointment
							oneAppointment.put("Doctor Name", doctorName);
							oneAppointment.put("Patient Name", patientName);
							oneAppointment.put("Date", getDate());
							//count decrease
							
							updatedCount = (long) appPossible.get("evening count");
							updatedAppPossible.put("Name", (updatedCount-1));

						}
						else 
						{
							//count assign to 5 again
							updatedAppPossible.put("evening count", 5);
							return false;
						}
						updatedAppPossible.put("Name", (String)(appPossible.get("Name")));
						updatedAppPossible.put("Name", (String)(appPossible.get("Availability")));
					}
					else 
					{
						if((long)appPossible.get("morning count")>0) 
						{
							//fix appointment
							oneAppointment.put("Doctor Name", doctorName);
							oneAppointment.put("Patient Name", patientName);
							oneAppointment.put("Date", getDate());
							//count decrease
							updatedCount = (long) appPossible.get("morning count");
							updatedAppPossible.put("morning count", (updatedCount-1));
							updatedAppPossible.put("evening count", (long)(appPossible.get("evening count")));

						}
						else if((long)appPossible.get("evening count")>0)
						{
							//fix appointment
							oneAppointment.put("Doctor Name", doctorName);
							oneAppointment.put("Patient Name", patientName);
							oneAppointment.put("Date", getDate());
							//count decrease
							updatedCount = (long) appPossible.get("evening count");
							updatedAppPossible.put("evening count", (updatedCount-1));
							updatedAppPossible.put("morning count", (long)(appPossible.get("morning count")));
						}
						else 
						{
							//morning count and evening count assign to 5 again
							updatedAppPossible.put("morning count", 5);
							updatedAppPossible.put("evening count", 5);
							return false;
						}
						updatedAppPossible.put("Name", (String)(appPossible.get("Name")));
						updatedAppPossible.put("Name", (String)(appPossible.get("Availability")));
						//writing updated count into file
						updatedAppointmentCount.add(updatedAppPossible);
						Utility.fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointmentCount.json", updatedAppointmentCount);
					}
					
					if(fileCreationResult) 
					{
						appointments.add(oneAppointment);
						Utility.fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/Appointment.json", appointments);
					}
					else 
					{
						Utility.fileReadingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/Appointment.json", oneAppointment);
					}
				}
				else 
				{
					updatedAppPossible = (JSONObject) appointmentCount.get(i);
					updatedAppointmentCount.add(updatedAppPossible);
				}
			}
		} 
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}
		
		if(type.equals("firstTry")) 
		{
			//doctor name then its count should be >0
			//then fix appointment
		}
		else if(type.equals("!firstTry"))
		{
			
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	public static String getDate() 
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateobj = new Date();
		String currentDate = dateFormat.format(dateobj);
		return currentDate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
