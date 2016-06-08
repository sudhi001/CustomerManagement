package com.akash.spring.crm.test.webservices.rest.model.customer;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="customers")
public class CustomerCollectionRepresentation 
{
	private List<CustomerRestClientObject> customers;

	public CustomerCollectionRepresentation() {}
	
	public CustomerCollectionRepresentation(List<CustomerRestClientObject> customers) {
		this.customers = customers;
	}

	@XmlElement(name="customer")
	public List<CustomerRestClientObject> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerRestClientObject> customers) {
		this.customers = customers;
	}
	
	public String toString()
	{
		return "The customers are " + customers.toString();
	}
}

