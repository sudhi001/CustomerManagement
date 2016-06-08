package com.akash.spring.crm.test.runners;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.akash.spring.crm.test.webservices.rest.exception.CustomExceptionHandler;
import com.akash.spring.crm.test.webservices.rest.model.call.CallClientVersion;
import com.akash.spring.crm.test.webservices.rest.model.customer.CustomerRestClientObject;


public class CRMRESTClient 
{	
	public static void main(String[] args) throws IOException
	{
		RestTemplate template = new RestTemplate();
//		template.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		template.setErrorHandler(new CustomExceptionHandler(template));
		
		
		// create customer
//		CustomerRestClientObject customer = new CustomerRestClientObject();
//		customer.setCompany("Random InNCe");
//		customer.setCustomerNotes("something");
//		CallClientVersion call = new CallClientVersion();
//		call.setCallNotes("ffdddf");
//		customer.addCall(call);
//		URI uri = template.postForLocation("http://localhost:8080/crm/rest/customers", customer);
//		System.out.println(uri);
//		
		// delete customer
		template.delete("http://localhost:8080/crm/rest/customer/c_63_5");
		
//		// update customer
//		CustomerRestClientObject customer = new CustomerRestClientObject();
//		customer.setCompany("Random");
//		customer.setCustomerNotes("nwe roo");
//		HttpEntity<CustomerRestClientObject> requestEntity = new HttpEntity<CustomerRestClientObject>(customer);
//		
//		template.exchange("http://localhost:8080/crm/customer/c_20_5", HttpMethod.PUT,
//				requestEntity, CustomerRestClientObject.class);
//		
//		// partial update customer
//		CustomerRestClientObject customer = new CustomerRestClientObject();
//		customer.setCompany("Random");
//		customer.setCustomerNotes("nwe roo");
//		HttpEntity<CustomerRestClientObject> requestEntity = new HttpEntity<CustomerRestClientObject>(customer);
//		
//		template.exchange("http://localhost:8080/crm/customer/c_20_5", HttpMethod.PUT,
//				requestEntity, CustomerRestClientObject.class);
//		
		

		// add call to customer
//		CallClientVersion call = new CallClientVersion();
//		call.setCallNotes("heyu t");
////		call.setCallTime(new Date());
//		CustomerRestClientObject found = 
//				template.getForObject("http://localhost:8080/crm/customer/c_20_5", CustomerRestClientObject.class);
//
//		URI uri = template.postForLocation("http://localhost:8080/crm/customer/c_20_5/calls", call);		
//		System.out.println(found.getCalls().get(0).getCallNotes());
//		CustomerRestClientObject found = template.getForObject("http://localhost:8080/crm/customer/c_45_5", CustomerRestClientObject.class);
//		System.out.println(found.getCid());
//		System.out.println(found.getCalls().get(0).getCallNotes());
	}
}
