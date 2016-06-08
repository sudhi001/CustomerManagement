
package com.akash.spring.crm.test.webservices.soap.services;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CRMServiceService", targetNamespace = "http://www.akash.com/crm/crmservice", wsdlLocation = "http://localhost:8080/crm/webservices/crm.wsdl")
public class CRMServiceService
    extends Service
{

    private final static URL CRMSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException CRMSERVICESERVICE_EXCEPTION;
    private final static QName CRMSERVICESERVICE_QNAME = new QName("http://www.akash.com/crm/crmservice", "CRMServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/crm/webservices/crm.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CRMSERVICESERVICE_WSDL_LOCATION = url;
        CRMSERVICESERVICE_EXCEPTION = e;
    }

    public CRMServiceService() {
        super(__getWsdlLocation(), CRMSERVICESERVICE_QNAME);
    }

    public CRMServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CRMSERVICESERVICE_QNAME, features);
    }

    public CRMServiceService(URL wsdlLocation) {
        super(wsdlLocation, CRMSERVICESERVICE_QNAME);
    }

    public CRMServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CRMSERVICESERVICE_QNAME, features);
    }

    public CRMServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CRMServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CRMService
     */
    @WebEndpoint(name = "CRMServiceSoap11")
    public CRMService getCRMServiceSoap11() {
        return super.getPort(new QName("http://www.akash.com/crm/crmservice", "CRMServiceSoap11"), CRMService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CRMService
     */
    @WebEndpoint(name = "CRMServiceSoap11")
    public CRMService getCRMServiceSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.akash.com/crm/crmservice", "CRMServiceSoap11"), CRMService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CRMSERVICESERVICE_EXCEPTION!= null) {
            throw CRMSERVICESERVICE_EXCEPTION;
        }
        return CRMSERVICESERVICE_WSDL_LOCATION;
    }

}
