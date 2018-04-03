package com.bridgeit.objectoriented;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;

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
	
	//"/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointment.json"
	//"/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointmentCount.json"
	/**
	 * the method fix the appointment for the patient for the current day.
	 * 
	 * @param doctorName name of the doctor
	 * @param patientName name of the patient
	 * @return true if the appointment is fixed else false
	 */
	public static boolean isAppointmentAvailable(String doctorName,String patientName) 
	{
		File file = new File("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointment.json");
		boolean fileCreationResult =false;
		
		JSONParser parser = new JSONParser();
		JSONArray fixAppointment = new JSONArray(); //appointment.json
		long retrievedMorningCount; long retrievedEveningCount;
		try
		{
			JSONArray appointmentCount = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointmentCount.json"));
			for(int i=0;i<appointmentCount.size();i++) 
			{
				JSONObject checkCount = (JSONObject) appointmentCount.get(i);
				
				JSONObject oneAppointment = new JSONObject(); //writing the one object into JSON array
				
				
				if(doctorName.equals((String)(checkCount.get("Name")))) 
				{
					fileCreationResult = file.createNewFile();
					//check availability
					if("AM".equals((String)(checkCount.get("Availability")))) 
					{
						retrievedMorningCount = (long)(checkCount.get("morning count"));
						//check morning count if it is >0 then only fix appointment for the current date
						if(retrievedMorningCount>0 && ((String)(checkCount.get("Date"))).equals(getDate())) 
						{
							//fix appointment
							oneAppointment.put("Doctor Name", doctorName);
							oneAppointment.put("Patient Name", patientName);
							oneAppointment.put("Date",getDate());
							
							if(fileCreationResult) 
							{
								fixAppointment.add(oneAppointment);
								Utility.fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointment.json",fixAppointment);
							}
							else 
							{
								Utility.fileReadingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointment.json",oneAppointment);
							}
							//then decrease morning count
							//remove that object from array
							//then add new object to the array with the updated count 
							//and write the entire array into file again
							
							checkCount.put("Name", doctorName);
							checkCount.put("Availability", "AM");
							checkCount.put("morning count", (retrievedMorningCount-1));
							checkCount.put("Date", getDate());
							appointmentCount.set(i, checkCount);
							Utility.fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointmentCount.json",appointmentCount);
							return true;
						}
						else if((long)checkCount.get("morning count") == 0)
						{
							//reassign morning count to 5 and return false
							checkCount.put("Name", doctorName);
							checkCount.put("Availability", "AM");
							checkCount.put("morning count", 5);
							checkCount.put("Date", getNextDate(getDate()));
							appointmentCount.set(i, checkCount);
							Utility.fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointmentCount.json",appointmentCount);
							return false;
						}
					}
					else if("PM".equals((String)(checkCount.get("Availability")))) 
					{
						retrievedEveningCount =(long)(checkCount.get("evening count"));
						//check evening count if it is >0 then only fix appointment
						if(retrievedEveningCount>0 && ((String)(checkCount.get("Date"))).equals(getDate())) 
						{
							//fix appointment
							oneAppointment.put("Doctor Name", doctorName);
							oneAppointment.put("Patient Name", patientName);
							oneAppointment.put("Date",getDate());
							
							if(fileCreationResult) 
							{
								fixAppointment.add(oneAppointment);
								Utility.fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointment.json",fixAppointment);
							}
							else 
							{
								Utility.fileReadingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointment.json",oneAppointment);
							}
							//then decrease evening count
							checkCount.put("Name", doctorName);
							checkCount.put("Availability", "PM");
							checkCount.put("evening count", (retrievedEveningCount-1));
							checkCount.put("Date", getDate());
							appointmentCount.set(i, checkCount);
							Utility.fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointmentCount.json",appointmentCount);
							return true;
						}
						else if((long)checkCount.get("evening count") == 0)
						{
							//reassign evening count to 5 and return false
							checkCount.put("Name", doctorName);
							checkCount.put("Availability", "PM");
							checkCount.put("evening count", 5);
							checkCount.put("Date", getNextDate(getDate()));
							appointmentCount.set(i, checkCount);
							Utility.fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointmentCount.json",appointmentCount);
							return false;
						}
						
					}
					else 
					{
						retrievedMorningCount = (long)(checkCount.get("morning count"));
						retrievedEveningCount = (long)(checkCount.get("evening count"));
						//check morning count >0 if yes fix appointment if no then check
						//evening count >0 if yes then fix appointment else return false
						if(retrievedMorningCount>0 && ((String)(checkCount.get("Date"))).equals(getDate())) 
						{
							//fix appointment
							oneAppointment.put("Doctor Name", doctorName);
							oneAppointment.put("Patient Name", patientName);
							oneAppointment.put("Date",getDate());
							
							if(fileCreationResult) 
							{
								fixAppointment.add(oneAppointment);
								Utility.fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointment.json",fixAppointment);
							}
							else 
							{
								Utility.fileReadingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointment.json",oneAppointment);
							}
							//then decrease morning count and keep evening count as it is
							checkCount.put("Name", doctorName);
							checkCount.put("Availability", "Both");
							checkCount.put("morning count", (retrievedMorningCount-1));
							checkCount.put("evening count", retrievedEveningCount);
							checkCount.put("Date", getDate());
							appointmentCount.set(i, checkCount);
							Utility.fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointmentCount.json",appointmentCount);
							return true;
						}
						else if(retrievedEveningCount>0 && ((String)(checkCount.get("Date"))).equals(getDate())) 
						{
							//fix appointment
							oneAppointment.put("Doctor Name", doctorName);
							oneAppointment.put("Patient Name", patientName);
							oneAppointment.put("Date",getDate());
							
							if(fileCreationResult) 
							{
								fixAppointment.add(oneAppointment);
								Utility.fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointment.json",fixAppointment);
							}
							else 
							{
								Utility.fileReadingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointment.json",oneAppointment);
							}
							//decrease evening count and keep morning count as it is
							checkCount.put("Name", doctorName);
							checkCount.put("Availability", "Both");
							checkCount.put("morning count", retrievedMorningCount);
							checkCount.put("evening count", (retrievedEveningCount-1));
							checkCount.put("Date", getDate());
							appointmentCount.set(i, checkCount);
							Utility.fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointmentCount.json",appointmentCount);
							return true;
						}
						else if((long)checkCount.get("evening count") == 0 && (long)checkCount.get("morning count") == 0)
						{
							//reassign morning and evening count to 5 and return false
							checkCount.put("Name", doctorName);
							checkCount.put("Availability", "Both");
							checkCount.put("morning count", 5);
							checkCount.put("evening count", 5);
							checkCount.put("Date", getNextDate(getDate()));
							appointmentCount.set(i, checkCount);
							Utility.fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointmentCount.json",appointmentCount);
							return false;
						}
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
	/**
	 * the method fix the appointment for the patient when the doctor 
	 * is not available for the current day. 
	 * 
	 * @param doctorName name of the doctor
	 * @param patientName name of the patient 
	 * @param date the date on which the patient want the treatment
	 * @return true when the appointment is booked else false
	 */
	public static boolean isAppointmentAvailableForNextDay(String doctorName,String patientName)
	{
		//the whole purpose of writing this method is to give next day appointment to the user.
		//the patient is not able get an appointment because count was 0 so here we will assign him appointment
		//count is already re assign to 5 by the last else part.
		//so directly assign him appointment for the next day
		//then decrease count that's it
		File file = new File("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointment.json");
		boolean fileCreationResult =false;
		
		JSONParser parser = new JSONParser();
		JSONArray fixAppointment = new JSONArray(); //appointment.json
		JSONObject oneAppointment = new JSONObject(); //writing the one object into JSON array
		long retrievedMorningCount; long retrievedEveningCount;
		try 
		{
			JSONArray appointmentCount = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointmentCount.json"));
			for(int i=0;i<appointmentCount.size();i++) 
			{
				JSONObject checkCount = (JSONObject) appointmentCount.get(i);
				if(doctorName.equals((String)(checkCount.get("Name")))) 
				{
					fileCreationResult = file.createNewFile();
					//fix  appointment
					oneAppointment.put("Doctor Name", doctorName);
					oneAppointment.put("Patient Name", patientName);
					oneAppointment.put("Date", getNextDate(getDate()));
					
					if(fileCreationResult) 
					{
						fixAppointment.add(oneAppointment);
						Utility.fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointment.json",fixAppointment);
					}
					else 
					{
						Utility.fileReadingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointment.json",oneAppointment);
					}
					//decrease count 
					checkCount.put("Name", doctorName);
					if("AM".equals((String)(checkCount.get("Availability")))) 
					{
						checkCount.put("Availability","AM");
						retrievedMorningCount = (long)(checkCount.get("morning count"));
						checkCount.put("morning count", (retrievedMorningCount-1));
					}
					else if("PM".equals((String)(checkCount.get("Availability"))))
					{
						checkCount.put("Availability","PM");
						retrievedEveningCount = (long)(checkCount.get("evening count"));
						checkCount.put("evening count", (retrievedEveningCount-1));
					}
					else 
					{
						checkCount.put("Availability","Both");
						retrievedMorningCount = (long)(checkCount.get("morning count"));
						checkCount.put("morning count", (retrievedMorningCount-1));
						retrievedEveningCount = (long)(checkCount.get("evening count"));
						checkCount.put("evening count", retrievedEveningCount);
					}
					checkCount.put("Date", getNextDate(getDate()));
					appointmentCount.set(i, checkCount);
					Utility.fileWritingInJSON("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointmentCount.json",appointmentCount);
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

	
	public static void getReport() 
	{
		JSONParser parser = new JSONParser();
		
		try 
		{
			JSONArray appointments = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Pranit/Programs/JSONFiles/clinique/appointment.json"));
			for(int i=0;i<appointments.size();i++) 
			{
				JSONObject appointment = (JSONObject) appointments.get(i);
				printReport(appointment);
			}
		} 
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	public static void printReport(JSONObject appointment) 
	{
		System.out.println("Doctor Name : "+(String)(appointment.get("Doctor Name")));
		System.out.println("Patient Name : "+(String)(appointment.get("Patient Name")));
		System.out.println("Date : "+(String)(appointment.get("Date")));
		System.out.println();
	}
	
	/**
	 * the static variable HIGH is used to store the highest element from the array
	 */
	static int HIGH = 0;
	/**
	 * the static variable POPULAR is used to get the maximum number of times occurred element from list
	 */
	static int POPULAR = 0;
	public static String getMaximumValue(String path,String name) 
	{
		//to store the value names
		ArrayList<String> value = new ArrayList<String>();
		
		JSONParser parser = new JSONParser();
		
		try 
		{
			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(path));
			
			for(int i=0;i<jsonArray.size();i++) 
			{
				JSONObject oneValue = (JSONObject) jsonArray.get(i);
				value.add((String) oneValue.get(name));
			}
			//to store non duplicate doctor names 
			LinkedHashSet<String> nonDuplicateValue = new LinkedHashSet<String>(value);
			int[] noofTimes = new int[nonDuplicateValue.size()]; //reference array to store the doctor count
			//finding the doctor count
			int count = 0;
			Iterator<String> iterator = nonDuplicateValue.iterator();
			while(iterator.hasNext()) 
			{
				String doctor = iterator.next();
				for(int j=0;j<value.size();j++) 
				{
					if(value.get(j).equals(doctor))
					{
						noofTimes[count]++;
					}
				}
				count++;
			}
			//finding the doctor who handled most patients
			for(int i=0;i<noofTimes.length;i++) 
			{
				if(noofTimes[i]>HIGH) 
				{
					HIGH = noofTimes[i];
					POPULAR = i;
				}
			}
			//converting the set into arraylist to get the element easily.
			ArrayList<String> popularity = new ArrayList<String>(nonDuplicateValue);
			return popularity.get(POPULAR);
			
		} 
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static String getDate() 
	{
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date dateobj = new Date();
		String currentDate = dateFormat.format(dateobj);
		return currentDate;
	}
	
	public static String getNextDate(String currentDate) 
	{
		 String nextDate = "";
	        try 
	        {
	            Calendar today = Calendar.getInstance();
	            DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	            Date date = format.parse(currentDate);
	            today.setTime(date);
	            today.add(Calendar.DAY_OF_YEAR, 1);
	            nextDate = format.format(today.getTime());
	        } 
	        catch (Exception e) 
	        {
	            return nextDate;
	        }
	        return nextDate;
	}
}
