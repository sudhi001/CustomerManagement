package com.akash.spring.crm.test.webservices.rest.model.customer;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.akash.spring.crm.test.webservices.rest.model.call.CallClientVersion;

@XmlRootElement(name = "customer")
public class CustomerRestClientObject {

	private String company;
	private String customerNotes;
	private String email;
	private String cid;
	private String telephone;
	private List<CallClientVersion> calls = new ArrayList<>();

	public List<CallClientVersion> getCalls() {
		return calls;
	}

	public void setCalls(List<CallClientVersion> calls) {
		this.calls = calls;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCustomerNotes() {
		return customerNotes;
	}

	public void setCustomerNotes(String customerNotes) {
		this.customerNotes = customerNotes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public void addCall(CallClientVersion call) {
		this.calls.add(call);
	}

}
