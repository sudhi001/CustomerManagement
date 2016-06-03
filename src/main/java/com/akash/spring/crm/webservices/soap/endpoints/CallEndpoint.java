package com.akash.spring.crm.webservices.soap.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import com.akash.spring.crm.model.Call;
import com.akash.spring.crm.services.calls.CallService;
import com.akash.spring.crm.webservices.soap.xml.calls.CallXML;
import com.akash.spring.crm.webservices.soap.xml.calls.CreateCallRequest;
import com.akash.spring.crm.webservices.soap.xml.calls.RemoveCallRequest;
import com.akash.spring.crm.webservices.soap.xml.calls.UpdateCallRequest;

@Endpoint
public class CallEndpoint {

    public static final String NAMESPACE = "http://www.akash.com/crm/calls";

    @Autowired
    private CallService callService;
    
    @PayloadRoot(namespace = NAMESPACE, localPart = "createCallRequest")
    public void createCall(@RequestPayload CreateCallRequest request) {
    	CallXML callXML = request.getCall();
    	Call call = new Call();
    	call.setId(callXML.getId());
    	call.setCallNotes(callXML.getCallNotes());
    	call.setCallTime(callXML.getCallTime().toGregorianCalendar().toZonedDateTime().toLocalDateTime());
    	callService.create(call);
    }
    
    @PayloadRoot(namespace = NAMESPACE, localPart = "removeCallRequest")
    public void removeCall(@RequestPayload RemoveCallRequest request) {
    	CallXML callXML = request.getCall();
    	Call call = new Call();
    	call.setId(callXML.getId());
    	call.setCallNotes(callXML.getCallNotes());
    	call.setCallTime(callXML.getCallTime().toGregorianCalendar().toZonedDateTime().toLocalDateTime());
    	callService.remove(call);
    }
    
    @PayloadRoot(namespace = NAMESPACE, localPart = "updateCallRequest")
    public void updateCall(@RequestPayload UpdateCallRequest request) {
    	CallXML callXML = request.getCall();
    	Call call = new Call();
    	call.setId(callXML.getId());
    	call.setCallNotes(callXML.getCallNotes());
    	call.setCallTime(callXML.getCallTime().toGregorianCalendar().toZonedDateTime().toLocalDateTime());
    	callService.update(call);
    }
}
