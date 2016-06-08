package com.akash.spring.crm.test.runners;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import com.akash.spring.crm.test.webservices.soap.model.actions.Action;
import com.akash.spring.crm.test.webservices.soap.model.actions.GetAllIncompleteActionsRequest;
import com.akash.spring.crm.test.webservices.soap.model.actions.GetAllIncompleteActionsResponse;
import com.akash.spring.crm.test.webservices.soap.model.actions.RecordActionRequest;
import com.akash.spring.crm.test.webservices.soap.model.calls.Call;
import com.akash.spring.crm.test.webservices.soap.model.calls.CreateCallRequest;
import com.akash.spring.crm.test.webservices.soap.model.customers.AddCustomerRequest;
import com.akash.spring.crm.test.webservices.soap.model.customers.Customer;
import com.akash.spring.crm.test.webservices.soap.model.customers.DeleteCustomerRequest;
import com.akash.spring.crm.test.webservices.soap.model.customers.GetCustomerByCompanyNameRequest;
import com.akash.spring.crm.test.webservices.soap.model.customers.GetCustomerByCompanyNameResponse;
import com.akash.spring.crm.test.webservices.soap.model.customers.GetCustomerByIdRequest;
import com.akash.spring.crm.test.webservices.soap.model.customers.GetCustomerByIdResponse;
import com.akash.spring.crm.test.webservices.soap.model.customers.GetFullCustomerDetailsRequest;
import com.akash.spring.crm.test.webservices.soap.model.customers.GetFullCustomerDetailsResponse;
import com.akash.spring.crm.test.webservices.soap.model.customers.UpdateCustomerRequest;
import com.akash.spring.crm.test.webservices.soap.services.CRMService;
import com.akash.spring.crm.test.webservices.soap.services.CRMServiceService;

public class CRMSOAPClient {
	
	private CRMService service;
	private static final String id = "c_79_5";
	
	@Before
	public void setUp() {
		this.service = new CRMServiceService().getCRMServiceSoap11();
	}
	
	@Test
	public void testRecordAction() {
		Action action = new Action();
		action.setOwner("mwe");
		action.setDetails("testieeng");
		action.setRequiredBy(xmlGregorianCalendarGenerator());
		RecordActionRequest recordActionRequest = new RecordActionRequest();
		recordActionRequest.setAction(action);
		service.recordAction(recordActionRequest);
	}


	
	@Test
	public void testGetAllIncompleteActions() {
		GetAllIncompleteActionsRequest getAllIncompleteActionsRequest = new GetAllIncompleteActionsRequest();
		getAllIncompleteActionsRequest.setOwner("mw");
		GetAllIncompleteActionsResponse response = service.getAllIncompleteActions(getAllIncompleteActionsRequest);
		List<Action> list = response.getAction();
		for (Action action : list) {
			System.out.println(action.getOwner());
			System.out.println(action.getRequiredBy());
			System.out.println(action.getDetails());
		}
	}
	
	@Test
	public void testAddCustomer() {
		Customer customerAdd = new Customer();
		customerAdd.setCompany("ABC");
		customerAdd.setCustomerNotes("HelloWorld");
		AddCustomerRequest add = new AddCustomerRequest();
		add.setCustomer(customerAdd);
		service.addCustomer(add);
	}
	
	@Test
	public void testFindCustomerById() {
		GetCustomerByIdRequest getCustomerByIdRequest = new GetCustomerByIdRequest();
		getCustomerByIdRequest.setId(id);
		GetCustomerByIdResponse customerById = service.getCustomerById(getCustomerByIdRequest);
		Customer customer = customerById.getCustomer();
		System.out.println(customer.getCompany());
		System.out.println(customer.getCustomerNotes());
		System.out.println(customer.getTelephone());
	}
	
	@Test
	public void testFindCustomerByCompanyName() {
		GetCustomerByCompanyNameRequest getCustomerByCompanyNameRequest = new GetCustomerByCompanyNameRequest();
		getCustomerByCompanyNameRequest.setCompanyName("ABC");
		GetCustomerByCompanyNameResponse response = service.getCustomerByCompanyName(getCustomerByCompanyNameRequest);
		List<Customer> customer2 = response.getCustomer();
		for (Customer c : customer2) {
			System.out.println(c.getCompany());
			System.out.println(c.getCustomerNotes());
			System.out.println(c.getTelephone());
		}
	}
	
	@Test
	public void testGetCustomerFullDetailsById() {
		GetFullCustomerDetailsRequest getFullCustomerDetailsRequest = new GetFullCustomerDetailsRequest();
		getFullCustomerDetailsRequest.setId(id);
		GetFullCustomerDetailsResponse response2 = service.getFullCustomerDetails(getFullCustomerDetailsRequest);
		Customer customer2 = response2.getCustomer();
		System.out.println(customer2.getCompany());
		System.out.println(customer2.getCustomerNotes());
		System.out.println(customer2.getTelephone());
		List<Call> calls = customer2.getCalls();
		for (Call call : calls) {
			System.out.println(call.getCallNotes());
		}
	}
	
	@Test
	public void testUpdateCustomer() {
	 	GetCustomerByIdRequest getCustomerByIdRequest = new GetCustomerByIdRequest();
		getCustomerByIdRequest.setId(id);
		GetCustomerByIdResponse customerById = service.getCustomerById(getCustomerByIdRequest);
		Customer customer = customerById.getCustomer();
		customer.setEmail("test");
		XMLGregorianCalendar xgcal = xmlGregorianCalendarGenerator();
		CreateCallRequest createCall = new CreateCallRequest();		
		Call call = new Call();
		call.setCallNotes("SOAP Cal 1");	
		call.setCallTime(xgcal);
		createCall.setCall(call);
		customer.getCalls().add(call);
		UpdateCustomerRequest updateCustomerRequest = new UpdateCustomerRequest();
		updateCustomerRequest.setCustomer(customer);
	    service.updateCustomer(updateCustomerRequest);		
	}
	
	@Test
	public void testDeleteCustomer() {
	 	GetCustomerByIdRequest getCustomerByIdRequest = new GetCustomerByIdRequest();
		getCustomerByIdRequest.setId(id);
		GetCustomerByIdResponse customerById = service.getCustomerById(getCustomerByIdRequest);
		Customer customer = customerById.getCustomer();
		DeleteCustomerRequest deleteCustomerRequest = new DeleteCustomerRequest();
		deleteCustomerRequest.setCustomer(customer);
		service.deleteCustomer(deleteCustomerRequest);	
	}
	
	@Test
	public void testCreateCall() {
		XMLGregorianCalendar xgcal = xmlGregorianCalendarGenerator();
		CreateCallRequest create = new CreateCallRequest();
		Call call = new Call();
		call.setCallNotes("SOAP Cal");	
		call.setCallTime(xgcal);
		create.setCall(call);
	}
	
	private XMLGregorianCalendar xmlGregorianCalendarGenerator() {
		LocalDateTime callTime = LocalDateTime.now();
		GregorianCalendar gcal = GregorianCalendar.from(callTime.atZone(ZoneId.systemDefault()));
		XMLGregorianCalendar xgcal = null;
		try {
			xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return xgcal;
	}
}
