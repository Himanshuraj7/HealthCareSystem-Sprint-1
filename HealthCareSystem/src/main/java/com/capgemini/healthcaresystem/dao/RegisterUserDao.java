package com.capgemini.healthcaresystem.dao;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.healthcaresystem.dto.Appointment;
import com.capgemini.healthcaresystem.dto.Test;
import com.capgemini.healthcaresystem.dto.User;
import com.capgemini.healthcaresystem.ui.RegisterUser;
import com.capgemini.healthcaresystem.util.CenterAndTestRepository;
import com.capgemini.healthcaresystem.util.UserRepository;

	public class RegisterUserDao {
		int randomappointmentId=10001;
		int generateappointmentId() {
    	randomappointmentId+=1;
  	  	return randomappointmentId;
    }
    
	private List <Appointment> appointmentList=new ArrayList<Appointment>();
	UserRepository userRepositoryobj=new UserRepository();
	
	public User registerUserDao(User user){
		String userId=generateUserId();
		user.setUserId(userId); // setting the user id to util package
		List<User> userList=userRepositoryobj.getUserList(); 
		boolean result=userList.add(user); // setting the user input from customer to util package
		if(result) {
			return user;
		}
		else {
			return null;
		}
	}
	
	public String loginUserServiceDao(String uName, String uPass) {
		
		UserRepository userRepositoryobj=new UserRepository();
		for(User i : userRepositoryobj.user) { // checking if the user name and password entered exist in util or not
			if(i.getUserName().equals(uName) && i.getUserPassword().equals(uPass)) {
				return "login successful";
			}
		}
		return "Id or Password do not match";
	}
	
	public String generateUserId() {
		int randomUserId=UserRepository.getRandomUserId()+1;
		UserRepository.setRandomUserId(randomUserId);
  	  return Integer.toString(randomUserId);
    }
	
	// bookAppointmentUserDao
	public String bookAppointmentUserDao(String dateTime, String testNameTemp) {
		RegisterUser registerUserobj= new RegisterUser();
		
		String uId=null, eId=null, cNo=null, tId=null;
		LocalDateTime dTime;
		boolean approved = false;
		
		UserRepository userRepositoryobj=new UserRepository();
		for(User i : userRepositoryobj.user) { // getting the user values for the user name logged in
			if(i.getUserName().equals(registerUserobj.uName) && i.getUserPassword().equals(registerUserobj.uPass)) {
				uId=i.getUserId();
				eId=i.getEmailId();
				cNo=i.getContactNo();
			}
		}
		User user=new User(uId, registerUserobj.uPass,  "user", registerUserobj.uName, eId, cNo);
		
		BigInteger appointmentId=BigInteger.valueOf(generateappointmentId());
		
		for(Test i : CenterAndTestRepository.listOfTests) {
			if(i.getTestName().equals(testNameTemp)) {
				tId=i.getTestId();
			}
		}
			Test t=new Test(tId, testNameTemp);
			
			dTime= LocalDateTime.parse(dateTime); 
			
			Appointment appointment=new Appointment(user, appointmentId, t, dTime, approved);
			appointmentList.add(appointment); // adding appointment to the appointment list

			return "Appointment booked, waiting for admin confirmation";
	}
}