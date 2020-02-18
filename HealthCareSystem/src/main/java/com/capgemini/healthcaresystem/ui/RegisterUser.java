package com.capgemini.healthcaresystem.ui;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.capgemini.healthcaresystem.dto.User;
import com.capgemini.healthcaresystem.exceptions.MyException;
import com.capgemini.healthcaresystem.services.RegisterUserService;

public class RegisterUser {
	String result=null;
	public String uName;
	public String uPass;
	Scanner sc=new Scanner(System.in);
	Scanner sc1=new Scanner(System.in);
	public int inputss;
	public LocalDateTime dateTime;
	String datetime;
	public void LoginOrSignUp() {
		
		
		System.out.println("1. SignUp");
		System.out.println("2. Login");
		inputss=sc.nextInt();
		if(inputss==2) {
			System.out.println("Enter UserName");
			uName=sc1.nextLine();
			System.out.println("Enter Password");
			uPass=sc1.nextLine();
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
    	catch(MyException e) {
    		System.out.println(e.getMessage());
    	}
    	return (user.getUserName()+" "+user.getContactNo()+" "+user.getUserPassword()+" "+user.getEmailId());
    	}
    	 
    	 
    	// login
		public String login(String uName, String uPass){
			
    		RegisterUserService userService=new RegisterUserService();
    		
    		try {
				result=userService.loginUserService(uName, uPass);
				return result;
			} 
    		catch(MyException e) {
        		System.out.println(e.getMessage());
        	}
    		finally {
    			System.out.println(result);
    		}
    		return null;
    	}
		
		
		// booking appointment
	public String bookAppointment(LocalDateTime dateTime){
		
		if(result=="login successful") {
			RegisterUserService userService=new RegisterUserService();
			
			try {
				result=userService.BookAppointment(dateTime);
				return result;
			} 
    		catch(Exception e) {
        		System.out.println(e.getMessage());
        	}
    		finally {
    			System.out.println(result);
    		}
	}
		return null;
	}
}
