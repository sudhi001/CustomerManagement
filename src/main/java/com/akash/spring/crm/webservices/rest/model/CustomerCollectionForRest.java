package com.akash.spring.crm.webservices.rest.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;

import com.akash.spring.crm.model.Customer;

@XmlRootElement(name = "customers")
public class CustomerCollectionForRest extends ResourceSupport{

	private List<Customer> customers;

	@XmlElement(name = "customer")
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "CustomerCollectionForRest [customers=" + customers + "]";
	}
}
