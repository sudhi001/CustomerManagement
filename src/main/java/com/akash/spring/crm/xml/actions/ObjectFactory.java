//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.27 at 04:10:25 PM EDT 
//


package com.akash.spring.crm.xml.actions;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.akash.crm.actions package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.akash.crm.actions
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllIncompleteActionsRequest }
     * 
     */
    public GetAllIncompleteActionsRequest createGetAllIncompleteActionsRequest() {
        return new GetAllIncompleteActionsRequest();
    }

    /**
     * Create an instance of {@link GetAllIncompleteActionsResponse }
     * 
     */
    public GetAllIncompleteActionsResponse createGetAllIncompleteActionsResponse() {
        return new GetAllIncompleteActionsResponse();
    }

    /**
     * Create an instance of {@link ActionXML }
     * 
     */
    public ActionXML createAction() {
        return new ActionXML();
    }

    /**
     * Create an instance of {@link RecordActionRequest }
     * 
     */
    public RecordActionRequest createRecordActionRequest() {
        return new RecordActionRequest();
    }

}
