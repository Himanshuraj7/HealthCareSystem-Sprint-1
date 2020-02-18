package com.capgemini.healthcaresystem.util;

//import com.capgemini.healthcaresystem.dto.Appointment;
import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.dto.Test;
//import com.capgemini.healthcaresystem.dto.User;

import java.util.ArrayList;
import java.util.List;

public class CenterAndTestRepository {
	
	 public static List <Test> listOfTests=new ArrayList<Test>();
	 public static List<DiagnosticCenter> centerList=new ArrayList<DiagnosticCenter>();
	
	static int randomTestId=1000;
    public String generateTestId() {
  	  randomTestId+=1;
  	  return Integer.toString(randomTestId);
    }  
    
	public CenterAndTestRepository() {
		Test t1=new Test(generateTestId(), "Blood Test");
		Test t2=new Test(generateTestId(), "Suger Test");
		Test t3=new Test(generateTestId(), "Calcium Test");
		Test t4=new Test(generateTestId(), "XRay");
		Test t5=new Test(generateTestId(), "MRI Scan");
		
		listOfTests.add(t1);
		listOfTests.add(t2);
		listOfTests.add(t3);
		listOfTests.add(t4);
		listOfTests.add(t5);
		
		DiagnosticCenter d1=new DiagnosticCenter("Aims", generateTestId(), listOfTests);
		DiagnosticCenter d2=new DiagnosticCenter("Apolo", generateTestId(), listOfTests);
		DiagnosticCenter d3=new DiagnosticCenter("Medanta", generateTestId(), listOfTests);
		DiagnosticCenter d4=new DiagnosticCenter("Ganganayak", generateTestId(), listOfTests);
		DiagnosticCenter d5=new DiagnosticCenter("Thind", generateTestId(), listOfTests);
		
		centerList.add(d1);
		centerList.add(d2);
		centerList.add(d3);
		centerList.add(d4);
		centerList.add(d5);
		
		
	}

	public static List<DiagnosticCenter> getCenterList() {
		return centerList;
	}

	public static void setCenterList(List<DiagnosticCenter> centerList) {
		CenterAndTestRepository.centerList = centerList;
	}
	
}
