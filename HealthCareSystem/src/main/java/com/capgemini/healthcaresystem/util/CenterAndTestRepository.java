package com.capgemini.healthcaresystem.util;

import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.dto.Test;

import java.util.ArrayList;
import java.util.List;

public class CenterAndTestRepository {
	
	 public static List <Test> listOfTests=new ArrayList<Test>();
	 public static List<DiagnosticCenter> centerList=new ArrayList<DiagnosticCenter>();
	
	static int randomTestId=1000;
    public String generateTestId() { // generating random testid
  	  randomTestId+=1;
  	  return Integer.toString(randomTestId);
    }  
    
	public CenterAndTestRepository() {
		Test test1=new Test(generateTestId(), "Blood Test");
		Test test2=new Test(generateTestId(), "Suger Test");
		Test test3=new Test(generateTestId(), "Calcium Test");
		Test test4=new Test(generateTestId(), "XRay");
		Test test5=new Test(generateTestId(), "MRI Scan");
		
		listOfTests.add(test1);
		listOfTests.add(test2);
		listOfTests.add(test3);
		listOfTests.add(test4);
		listOfTests.add(test5);
		
		DiagnosticCenter diagnosticcenter1=new DiagnosticCenter("Aims", generateTestId(), listOfTests);
		DiagnosticCenter diagnosticcenter2=new DiagnosticCenter("Apolo", generateTestId(), listOfTests);
		DiagnosticCenter diagnosticcenter3=new DiagnosticCenter("Medanta", generateTestId(), listOfTests);
		DiagnosticCenter diagnosticcenter4=new DiagnosticCenter("Ganganayak", generateTestId(), listOfTests);
		DiagnosticCenter diagnosticcenter5=new DiagnosticCenter("Thind", generateTestId(), listOfTests);
		
		centerList.add(diagnosticcenter1);
		centerList.add(diagnosticcenter2);
		centerList.add(diagnosticcenter3);
		centerList.add(diagnosticcenter4);
		centerList.add(diagnosticcenter5);
	}

	public static List<DiagnosticCenter> getCenterList() {
		return centerList;
	}

	public static void setCenterList(List<DiagnosticCenter> centerList) {
		CenterAndTestRepository.centerList = centerList;
	}
}