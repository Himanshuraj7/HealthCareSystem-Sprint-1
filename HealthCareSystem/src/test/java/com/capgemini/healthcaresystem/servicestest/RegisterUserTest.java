package com.capgemini.healthcaresystem.servicestest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.capgemini.healthcaresystem.ui.RegisterUser;

public class RegisterUserTest {
	
	@Test
	void registerUserTest(){	
		RegisterUser obj=new RegisterUser();
		
		obj.LoginOrSignUp();
		
		if(obj.inputss==1)
		assertEquals("Himanshu 1234567890 Hello@123 hi@gmail.com",
				obj.regUser("Himanshu", "1234567890", "Hello@123", "hi@gmail.com"));	
		
		if(obj.inputss==2) {
			assertEquals("login successful", obj.login(obj.uName, obj.uPass));
			assertEquals("Appointment booked, waiting for admin confirmation", 
					obj.bookAppointment(LocalDateTime.parse("2018-11-03T12:45:30")),"Date and Time input is Wrong");
		}
	}
}
