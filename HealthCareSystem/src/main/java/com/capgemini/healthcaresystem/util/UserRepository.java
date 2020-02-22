package com.capgemini.healthcaresystem.util;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.dto.User;

public class UserRepository {

	  public List<User> user = new ArrayList<User>();
	  public List<DiagnosticCenter> centerList= new ArrayList<DiagnosticCenter>();
	  
      static int randomUserId=50;
      public String generateUserId() { // generating random user id
    	  randomUserId+=1;
    	  return Integer.toString(randomUserId);
      }  
      
      public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<DiagnosticCenter> getCenterList() {
		return centerList;
	}

	public void setCenterList(List<DiagnosticCenter> centerList) {
		this.centerList = centerList;
	}

	public static int getRandomUserId() {
		return randomUserId;
	}

	public static void setRandomUserId(int randomUserId) {
		UserRepository.randomUserId = randomUserId;
	}

	public UserRepository() {
    	  User user1=new User(generateUserId(), "Vishal#123", "user", "Vishal", "vishal@gmail.com", "9934760762");
    	  User user2=new User(generateUserId(), "Himanshu@988", "admin", "Himanshu", "himanshu@gmail.com", "8467679278");
    	  User user3=new User(generateUserId(), "Ashish@555", "user", "Ashish", "ashish@gmail.com", "7395016742");
    	  User user4=new User(generateUserId(), "Sachin#666", "user", "Sachin", "sachin@gmail.com", "6748945567");
    	  User user5=new User(generateUserId(), "Amardeep@1998", "admin", "Amardeep", "amardeep@gmail.com", "8409222678");
      
    	  user.add(user1);
    	  user.add(user2);
    	  user.add(user3);
    	  user.add(user4);
    	  user.add(user5);
    	  
      }
      
      public List<User> getUserList(){
    	  return user;
      }
}