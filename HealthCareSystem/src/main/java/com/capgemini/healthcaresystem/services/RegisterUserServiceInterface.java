package com.capgemini.healthcaresystem.services;

import com.capgemini.healthcaresystem.dto.User;
import com.capgemini.healthcaresystem.exceptions.InvalidUserData;

public interface RegisterUserServiceInterface {
	
	 boolean validatePassword(String password);
	 public User registerUserService(User user) throws InvalidUserData;
	 public String loginUserService(String uName, String uPass) throws InvalidUserData;
	 public String BookAppointment(String dateTime, String testNameTemp) throws InvalidUserData;
}
