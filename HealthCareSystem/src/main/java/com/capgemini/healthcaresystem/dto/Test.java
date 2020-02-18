package com.capgemini.healthcaresystem.dto;

public class Test {
	private String testId, testName;
	
	public Test(String testId, String testName) {
		super();
		this.testId = testId;
		this.testName = testName;
	}

	

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}
	
	
}
