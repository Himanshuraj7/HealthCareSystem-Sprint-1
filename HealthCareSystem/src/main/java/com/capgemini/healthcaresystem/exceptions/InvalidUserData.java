package com.capgemini.healthcaresystem.exceptions;

@SuppressWarnings("serial")
public class InvalidUserData extends Exception { // creating a user defined exception
	public InvalidUserData(String s) {
		super(s);
	}
}