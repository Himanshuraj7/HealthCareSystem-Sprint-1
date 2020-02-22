package com.capgemini.healthcaresystem.servicestest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.capgemini.healthcaresystem.ui.RegisterUser;

public class RegisterUserTest {
	
	@Test
	void registerUserTest(){	
		RegisterUser registerUserobj=new RegisterUser();
		
		registerUserobj.LoginOrSignUp();
		
		if(registerUserobj.loginOrSignUp==1) {// testing register user function
		assertEquals("Himanshu 1234567890 Hello@123 hi@gmail.com",
				registerUserobj.regUser("Himanshu", "1234567890", "Hello@123", "hi@gmail.com"));
		
		assertEquals("Gaurav 8409222436 Gaurav#123 gaurav@gmail.com",
				registerUserobj.regUser("Gaurav", "8409222436", "Gaurav#123", "gaurav@gmail.com"));
		}
		
		if(registerUserobj.loginOrSignUp==2) {
			assertEquals("login successful", registerUserobj.login(registerUserobj.uName, registerUserobj.uPass)); // testing login user function
			assertEquals("Appointment booked, waiting for admin confirmation", // testing book appointment function
					registerUserobj.bookAppointment("2020-11-03T12:45"));
		}
	}
}
