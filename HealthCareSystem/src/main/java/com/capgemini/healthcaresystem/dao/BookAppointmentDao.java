package com.capgemini.healthcaresystem.dao;

import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.dto.Test;
import com.capgemini.healthcaresystem.dto.User;
import com.capgemini.healthcaresystem.util.CenterAndTestRepository;
import com.capgemini.healthcaresystem.util.UserRepository;;

public class BookAppointmentDao {
	
//	@SuppressWarnings("static-access")
//	void printData()	{
//		UserRepository obj=new UserRepository();
//		
//		for(User i : obj.user) {
//			System.out.println(i.getContactNo());
//			System.out.println(i.getUserId());
//			System.out.println(i.getUserName());
//			System.out.println(i.getEmailId());
//			System.out.println(i.getUserPassword());
//			System.out.println(i.getUserRole());
//			System.out.println(i.getCenterList());
//			System.out.println();
//		}
//	}
	
//public static void main(String[] args) {
	
	public void book() {
		
	CenterAndTestRepository obj=new CenterAndTestRepository();
		
		for(DiagnosticCenter i : CenterAndTestRepository.centerList) {
			System.out.println(i.getCenterId());
			System.out.println(i.getCenterName());
			for(Test j : CenterAndTestRepository.listOfTests) {
			System.out.println(j.getTestName());	
		}
			System.out.println();
		}
		
	}
}
