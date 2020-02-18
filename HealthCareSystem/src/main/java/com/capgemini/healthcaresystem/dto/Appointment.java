package com.capgemini.healthcaresystem.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class Appointment {
	private User user;
	private BigInteger appointmentId;
	private Test test;
	private LocalDateTime dateTime;
	private boolean approved;
	
	public Appointment(User user, BigInteger appointmentId, Test test, LocalDateTime dateTime, boolean approved) {
		super();
		this.user = user;
		this.appointmentId = appointmentId;
		this.test = test;
		this.dateTime = dateTime;
		this.approved = approved;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BigInteger getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(BigInteger appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}
}
