package com.akash.spring.crm.webservices.soap.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.akash.spring.crm.exceptions.RecordNotFoundException;
import com.akash.spring.crm.model.Action;
import com.akash.spring.crm.services.action.ActionService;
import com.akash.spring.crm.webservices.soap.xml.actions.ActionXML;
import com.akash.spring.crm.webservices.soap.xml.actions.GetAllIncompleteActionsRequest;
import com.akash.spring.crm.webservices.soap.xml.actions.GetAllIncompleteActionsResponse;
import com.akash.spring.crm.webservices.soap.xml.actions.RecordActionRequest;

/**
 * Created by Akash Agarwal on 5/24/2016.
 */
@Endpoint
public class ActionEndpoint {

    public static final String NAMESPACE = "http://www.akash.com/crm/actions";

    @Autowired
    private ActionService actionService;

    @PayloadRoot(namespace = NAMESPACE, localPart = "getAllIncompleteActionsRequest")
    @ResponsePayload
    public GetAllIncompleteActionsResponse fetchAllIncompleteActions(@RequestPayload GetAllIncompleteActionsRequest request) {
    	String owner = request.getOwner();
    	List<Action> actions = null;
    	try {
    		actions = actionService.getAllIncompleteActions(owner);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	GetAllIncompleteActionsResponse response = new GetAllIncompleteActionsResponse(actions);
    	return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE, localPart = "recordActionRequest")
    public void recordActionRequest(@RequestPayload RecordActionRequest request) {
    	ActionXML actionXML = request.getAction();
    	Action action = new Action();
    	action.setDetails(actionXML.getDetails());
    	action.setOwner(actionXML.getOwner());
    	action.setRequiredBy(actionXML.getRequiredBy().toGregorianCalendar());
    	actionService.recordAction(action);
    }
}