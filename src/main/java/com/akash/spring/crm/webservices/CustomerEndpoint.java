package com.akash.spring.crm.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.model.Customer;
import com.akash.spring.crm.services.customer.CustomerService;
import com.akash.crm.GetCustomerByIdRequest;
import com.akash.crm.GetCustomerByIdResponse;

/**
 * Created by Akash Agarwal on 5/24/2016.
 */
@Endpoint
public class CustomerEndpoint {

    public static final String NAMESPACE = "http://www.akash.com/crm";

    @Autowired
    private CustomerService customerService;

    @PayloadRoot(namespace = NAMESPACE, localPart = "getCustomerByIdRequest")
    @ResponsePayload
    public GetCustomerByIdResponse fetchCustomerDetailsJaxBVersion(@RequestPayload GetCustomerByIdRequest request) throws CustomerNotFoundException {
    	String id = request.getId();
    	Customer customer = customerService.findCustomerById(id);
    	GetCustomerByIdResponse response = new GetCustomerByIdResponse(customer);
//    	response.setCustomer(customer);
    	return response;
    }
    
    
//    public Element fetchCustomerDetailsJDomVersion(@XPathParam("//id") String id,@RequestPayload Element incoming)
//            throws CustomerNotFoundException {
//     
//        Customer found = customerService.findCustomerById(id);
//
//        Element outgoing = new Element("getCustomerByIdResponse");
//        outgoing.addNamespaceDeclaration(Namespace.getNamespace("tns", NAMESPACE));
//
//        Element customer = new Element("customer");
//
//        customer.addContent(new Element("id").setText(found.getId()));
//        customer.addContent(new Element("company").setText(found.getCompany()));
//        customer.addContent(new Element("email").setText(found.getEmail()));
//
//        if (found.getTelephone() != null)
//            customer.addContent(new Element("telephone").setText(found.getTelephone()));
//
//        if (found.getCustomerNotes() != null)
//            customer.addContent(new Element("customerNotes").setText(found.getCustomerNotes()));
//
//        outgoing.addContent(customer);
//        return outgoing;
//    }
}