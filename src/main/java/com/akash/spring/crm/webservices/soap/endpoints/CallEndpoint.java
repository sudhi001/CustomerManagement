package com.akash.spring.crm.webservices.soap.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.model.Action;
import com.akash.spring.crm.model.Call;
import com.akash.spring.crm.services.calls.CallService;
import com.akash.spring.crm.webservices.soap.xml.calls.CallXML;
import com.akash.spring.crm.webservices.soap.xml.calls.RecordCallRequest;

@Endpoint
public class CallEndpoint {
	

    public static final String NAMESPACE = "http://www.akash.com/crm/calls";

    @Autowired
    private CallService callService;


    @PayloadRoot(namespace = NAMESPACE, localPart = "recordCallRequest")
    public void recordCall(@RequestPayload RecordCallRequest request) {
    	CallXML callXML = request.getCall();
    	Call call = new Call();
    	call.setCallNotes(callXML.getCallNotes());
    	call.setCallTime(callXML.getCallTime().toGregorianCalendar().toZonedDateTime().toLocalDateTime());
    	call.setId(callXML.getId());
    	List<Action> actions = request.getActions();
    	String id = request.getId();
    	try {
			callService.recordCall(id, call, actions);
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
		}
    }
}
