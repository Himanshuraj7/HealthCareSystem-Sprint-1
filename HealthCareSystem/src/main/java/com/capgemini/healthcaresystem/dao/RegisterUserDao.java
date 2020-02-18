package com.capgemini.healthcaresystem.dao;

import java.util.List;

import com.capgemini.healthcaresystem.dto.User;
import com.capgemini.healthcaresystem.util.UserRepository;

public class RegisterUserDao {
	UserRepository ur=new UserRepository();
	
	public User registerUserDao(User user){
		String userId=generateUserId();
		user.setUserId(userId);
		List<User> userList=ur.getUserList();
		boolean result=userList.add(user);
		if(result)
		{
			return user;
		}
		else {
			return null;
		}
		
	}
	
	public String generateUserId() {
		int randomUserId=UserRepository.getRandomUserId()+1;
		UserRepository.setRandomUserId(randomUserId);
  	  return Integer.toString(randomUserId);
    }
}
