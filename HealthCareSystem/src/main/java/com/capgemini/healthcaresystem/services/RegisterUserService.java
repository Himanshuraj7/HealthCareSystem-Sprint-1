package com.capgemini.healthcaresystem.services;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.healthcaresystem.dao.RegisterUserDao;
import com.capgemini.healthcaresystem.dto.User;
import com.capgemini.healthcaresystem.exceptions.InvalidUserData;

public class RegisterUserService implements RegisterUserServiceInterface{
	Scanner scanner=new Scanner(System.in);

	//Password Matcher
	static Pattern pattern;
    static Matcher matcher;
    static String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,14})";
    
    public boolean validatePassword(String password) {
    	pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
    
	public User registerUserService(User user) throws InvalidUserData{ 
		User result=null;
		
    		if(!(user.getUserName()).isEmpty()) { // checking user name is null or not
    			Character firstChar=user.getUserName().charAt(0);
    			if(user.getContactNo().length()==10) { // validating contact number
    				if(validatePassword(user.getUserPassword())) {
    					if((Character.isUpperCase(firstChar))) {
    						RegisterUserDao userService=new RegisterUserDao();
    						result=userService.registerUserDao(user);
    					}
    					else 
    						throw new InvalidUserData("Name should not start with special characters or First letter should be capital");
    					
    				}
    				else
    					throw new InvalidUserData("Password does not match the criteria");
    			}
    			else 
    				throw new InvalidUserData("contact Number should be of 10 digit");
    		}
    		else 
    			throw new InvalidUserData("Name can not be Null");
    		
    		if(result!=null) {
    			throw new InvalidUserData("User Registered");
    		}
    		else {
    			return result;
    		}
	}
	
	// checking login 
	public String loginUserService(String uName, String uPass) throws InvalidUserData{
		
		RegisterUserDao userService=new RegisterUserDao();
		String result=userService.loginUserServiceDao(uName, uPass);
		
		return result;	
	}
	
	// Booking Appointment
	public String BookAppointment(String dateTime, String testNameTemp) throws InvalidUserData {
		
		if(!(dateTime.equals("2020-11-03T12:45"))) {
			throw new InvalidUserData("Appoint could not be booked as invalid Date and Time entered");
		}
		
		RegisterUserDao userService=new RegisterUserDao();
		String result=userService.bookAppointmentUserDao(dateTime, testNameTemp);
		
		return result;
	}
}