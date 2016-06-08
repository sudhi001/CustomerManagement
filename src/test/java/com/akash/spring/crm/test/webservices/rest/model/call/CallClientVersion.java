package com.akash.spring.crm.test.webservices.rest.model.call;

import java.util.Date;

public class CallClientVersion {
	
    private int id;
    private Date callTime;
    private String callNotes;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCallTime() {
		return callTime;
	}
	public void setCallTime(Date callTime) {
		this.callTime = callTime;
	}
	public String getCallNotes() {
		return callNotes;
	}
	public void setCallNotes(String callNotes) {
		this.callNotes = callNotes;
	}
}
