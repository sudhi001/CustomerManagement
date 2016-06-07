package com.akash.spring.crm.webservices.rest.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.akash.spring.crm.model.Call;

@XmlRootElement(name = "calls")
public class CallCollectionForRest {

	private List<Call> callList;

	@XmlElement(name = "call")
	public List<Call> getCallList() {
		return callList;
	}

	public void setCallList(List<Call> callList) {
		this.callList = callList;
	}	
}
