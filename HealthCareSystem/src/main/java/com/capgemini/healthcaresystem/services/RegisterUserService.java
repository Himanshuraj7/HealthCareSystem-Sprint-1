package com.capgemini.healthcaresystem.services;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.healthcaresystem.dao.RegisterUserDao;
import com.capgemini.healthcaresystem.dto.Appointment;
import com.capgemini.healthcaresystem.dto.Test;
import com.capgemini.healthcaresystem.dto.User;
import com.capgemini.healthcaresystem.exceptions.MyException;
import com.capgemini.healthcaresystem.util.CenterAndTestRepository;
import com.capgemini.healthcaresystem.util.UserRepository;

public class RegisterUserService {
	Scanner sc=new Scanner(System.in);
	
	public String uName;
	public String uPass;
	public String uId, eId, cNo, tId;
	public LocalDateTime dTime;
	public boolean approved;
	public List <Test> listOfTests=new ArrayList<Test>();
	public List <Appointment> appointmentList=new ArrayList<Appointment>();
	String datetime;
	
	static int randomappointmentId=10001;
    public int generateappointmentId() {
    	randomappointmentId+=1;
  	  return randomappointmentId;
    } 

	
	//Password Matcher
	static Pattern pattern;
    static Matcher matcher;
    static String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,14})";
    
    public static boolean validatePassword(String password) {
    	pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
    
	public User registerUserService(User user) throws MyException{ 
		User result=null;
		
    		if(!(user.getUserName()).isEmpty()) {
    			Character firstChar=user.getUserName().charAt(0);
    			if(user.getContactNo().length()==10) {
    				if(validatePassword(user.getUserPassword())) {
    					if((Character.isUpperCase(firstChar))) {
    						RegisterUserDao userService=new RegisterUserDao();
    						result=userService.registerUserDao(user);
    					}
    					else 
    						throw new MyException("Name should not start with special characters and First letter should be capital");
    					
    				}
    				else
    					throw new MyException("Password does not match the criteria");
    			}
    			else 
    				throw new MyException("contact Number should be of 10 digit");
    		}
    		else 
    			throw new MyException("Name can not be Null");
    		
    		if(result!=null) {
    			throw new MyException("User Registered");
    		}
    		else {
    			return result;
    		}
	}
	public String loginUserService(String uName, String uPass) throws MyException{
		
		UserRepository obj=new UserRepository();
		for(User i : obj.user) {
			if(i.getUserName().equals(uName) && i.getUserPassword().equals(uPass)) {
				return "login successful";
			}
	}
		return "Id or Password do not match";
		
	}
	
	// Booking Appointment
	public String BookAppointment(LocalDateTime dateTime)throws MyException {
		
		System.out.println("1. Aims");
		System.out.println("2. Apolo");
		System.out.println("3. Medanta");
		System.out.println("4. Ganganayak");
		System.out.println("5. Thind");
		
		System.out.println("Select the center");
		int cName=sc.nextInt();
		
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
		int tName=sc.nextInt();
		
		String testNameTemp=null;
		if(tName==1)  testNameTemp="Blood Test";
		if(tName==2)  testNameTemp="Suger Test";
		if(tName==3)  testNameTemp="Calcium Test";
		if(tName==4)  testNameTemp="Xray";
		if(tName==5)  testNameTemp="MRI Scan";
		
		UserRepository obj=new UserRepository();
		for(User i : obj.user) {
			if(i.getUserName().equals(uName) && i.getUserPassword().equals(uPass)) {
				uId=i.getUserId();
				eId=i.getEmailId();
				cNo=i.getContactNo();
			}
	}
		User u=new User(uId, uPass,  "user", uName, eId, cNo);
		
		BigInteger appointmentId=BigInteger.valueOf(generateappointmentId());
		
		for(Test i : CenterAndTestRepository.listOfTests) {
			if(i.getTestName().equals(testNameTemp)) {
				tId=i.getTestId();
			}
		}
			Test t=new Test(tId, testNameTemp);
			
			dTime= dateTime;
			
				
			Appointment ob1=new Appointment(u, appointmentId, t, dTime, approved);
			appointmentList.add(ob1);
			System.out.println("You have Selected "+centerNameTemp+"Center");
			System.out.println("You have Selected "+ob1.getTest().getTestName()+"Test");
			System.out.println("You have Selected Time and date "+dTime);
			
	
		return "Appointment booked, waiting for admin confirmation";
	}
}