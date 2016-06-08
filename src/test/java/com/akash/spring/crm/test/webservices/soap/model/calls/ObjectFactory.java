
package com.akash.spring.crm.test.webservices.soap.model.calls;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.akash.crm.calls package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.akash.crm.calls
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateCallRequest }
     * 
     */
    public UpdateCallRequest createUpdateCallRequest() {
        return new UpdateCallRequest();
    }

    /**
     * Create an instance of {@link Call }
     * 
     */
    public Call createCall() {
        return new Call();
    }

    /**
     * Create an instance of {@link RemoveCallRequest }
     * 
     */
    public RemoveCallRequest createRemoveCallRequest() {
        return new RemoveCallRequest();
    }

    /**
     * Create an instance of {@link CreateCallRequest }
     * 
     */
    public CreateCallRequest createCreateCallRequest() {
        return new CreateCallRequest();
    }

}
