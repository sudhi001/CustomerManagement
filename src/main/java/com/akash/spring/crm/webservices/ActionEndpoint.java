package com.akash.spring.crm.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.akash.spring.crm.exceptions.RecordNotFoundException;
import com.akash.spring.crm.model.Action;
import com.akash.spring.crm.services.action.ActionService;
import com.akash.spring.crm.xml.actions.GetAllIncompleteActionsRequest;
import com.akash.spring.crm.xml.actions.GetAllIncompleteActionsResponse;

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
}