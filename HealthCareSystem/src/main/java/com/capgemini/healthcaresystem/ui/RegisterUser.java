package com.capgemini.healthcaresystem.ui;

import java.util.Scanner;

import com.capgemini.healthcaresystem.dto.User;
import com.capgemini.healthcaresystem.exceptions.InvalidUserData;
import com.capgemini.healthcaresystem.services.RegisterUserService;

public class RegisterUser {
	String result=null;
	public String uName;
	public String uPass;
	Scanner scanner=new Scanner(System.in);
	Scanner scanner1=new Scanner(System.in);
	public int loginOrSignUp;
	
	public void LoginOrSignUp() { // asking user to login or signup
		System.out.println("1. SignUp");
		System.out.println("2. Login");
		loginOrSignUp=scanner.nextInt();
		
		if(loginOrSignUp!=1 && loginOrSignUp!=2) {
			System.out.println("Invalid input");
		}
		
		if(loginOrSignUp==2) {
			System.out.println("Enter UserName");
			uName=scanner1.nextLine();
			System.out.println("Enter Password");
			uPass=scanner1.nextLine();
		}
	}
		
		// registering user
    public String regUser(String uName, String cNo, String uPass, String eId) {
    		String userName=uName, userPassword=uPass, contactNo=cNo, userRole="customer", emailId=eId, userId=null;
        	RegisterUserService userService=new RegisterUserService();
        	
        	User user=new User(userId, userPassword, userRole, userName, emailId, contactNo);
        	
    	try {
    		user=userService.registerUserService(user);
    	}
    	catch(InvalidUserData e) {
    		System.out.println(e.getMessage());
    	}
    	return (user.getUserName()+" "+user.getContactNo()+" "+user.getUserPassword()+" "+user.getEmailId());
    }
    	 
    	 
    	// login function
	public String login(String uName, String uPass){
    		RegisterUserService userService=new RegisterUserService();
    		
    		try {
				result=userService.loginUserService(uName, uPass);
				return result;
			} 
    		catch(InvalidUserData e) {
        		System.out.println(e.getMessage());
        	}
    		finally {
    			System.out.println(result);
    		}
    		return null;
    	}
		
		
		// booking appointment function
	public String bookAppointment(String dateTime){
		
		if(result=="login successful") {
			RegisterUserService userService=new RegisterUserService();
	
			System.out.println("1. Aims");
			System.out.println("2. Apolo");
			System.out.println("3. Medanta");
			System.out.println("4. Ganganayak");
			System.out.println("5. Thind");
			
			System.out.println("Select the center");
			int cName=scanner.nextInt();
			if(cName<1 || cName>5) {
				System.out.println("Invalid input");
				return null;
			}
			@SuppressWarnings("unused")
			String centerNameTemp=null;
			if(cName==1)  centerNameTemp="Aims";
			if(cName==2)  centerNameTemp="Apolo";
			if(cName==3)  centerNameTemp="Medanta";
			if(cName==4)  centerNameTemp="Ganganayak";
			if(cName==5)  centerNameTemp="Thind";
			
			System.out.println("1. Blood Test");
			System.out.println("2. Suger Test");
			System.out.println("3. Calcium Test");
			System.out.println("4. Xray");
			System.out.println("5. MRI Scan");
			
			System.out.println("Select the test type");
			int tName=scanner.nextInt();
			if(tName<1 || tName>5) {
				System.out.println("Invalid input");
				return null;
			}
			String testNameTemp=null;
			if(tName==1)  testNameTemp="Blood Test";
			if(tName==2)  testNameTemp="Suger Test";
			if(tName==3)  testNameTemp="Calcium Test";
			if(tName==4)  testNameTemp="Xray";
			if(tName==5)  testNameTemp="MRI Scan";
		
			try {
				result=userService.BookAppointment(dateTime, testNameTemp);
				System.out.println("You have selected "+centerNameTemp+" center");
				System.out.println("You have selected "+testNameTemp+" test");
				String dateAndTime[]=dateTime.split("T");
				System.out.println("You have selected "+dateAndTime[0]+" date");
				System.out.println("You have selected "+dateAndTime[1]+" time");
				return result;
			} 
    		catch(InvalidUserData e) {
        		System.out.println(e.getMessage());
        	}
    		finally {
    			scanner.close();
    			System.out.println(result);
    		}
		}	
		return null;
	}
	
}
