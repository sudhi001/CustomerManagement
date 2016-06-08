
package com.akash.spring.crm.test.webservices.soap.model.customers;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.akash.crm.customers package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.akash.crm.customers
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFullCustomerDetailsRequest }
     * 
     */
    public GetFullCustomerDetailsRequest createGetFullCustomerDetailsRequest() {
        return new GetFullCustomerDetailsRequest();
    }

    /**
     * Create an instance of {@link GetFullCustomerDetailsResponse }
     * 
     */
    public GetFullCustomerDetailsResponse createGetFullCustomerDetailsResponse() {
        return new GetFullCustomerDetailsResponse();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link DeleteCustomerRequest }
     * 
     */
    public DeleteCustomerRequest createDeleteCustomerRequest() {
        return new DeleteCustomerRequest();
    }

    /**
     * Create an instance of {@link UpdateCustomerRequest }
     * 
     */
    public UpdateCustomerRequest createUpdateCustomerRequest() {
        return new UpdateCustomerRequest();
    }

    /**
     * Create an instance of {@link GetCustomerByIdRequest }
     * 
     */
    public GetCustomerByIdRequest createGetCustomerByIdRequest() {
        return new GetCustomerByIdRequest();
    }

    /**
     * Create an instance of {@link GetCustomerByCompanyNameResponse }
     * 
     */
    public GetCustomerByCompanyNameResponse createGetCustomerByCompanyNameResponse() {
        return new GetCustomerByCompanyNameResponse();
    }

    /**
     * Create an instance of {@link AddCustomerRequest }
     * 
     */
    public AddCustomerRequest createAddCustomerRequest() {
        return new AddCustomerRequest();
    }

    /**
     * Create an instance of {@link GetCustomerByIdResponse }
     * 
     */
    public GetCustomerByIdResponse createGetCustomerByIdResponse() {
        return new GetCustomerByIdResponse();
    }

    /**
     * Create an instance of {@link GetCustomerByCompanyNameRequest }
     * 
     */
    public GetCustomerByCompanyNameRequest createGetCustomerByCompanyNameRequest() {
        return new GetCustomerByCompanyNameRequest();
    }

}
