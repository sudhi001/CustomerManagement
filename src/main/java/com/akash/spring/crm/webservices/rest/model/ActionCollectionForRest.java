package com.akash.spring.crm.webservices.rest.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.akash.spring.crm.model.Action;

@XmlRootElement(name = "actions")
public class ActionCollectionForRest {
	private List<Action> actionList;

	@XmlElement(name = "action")
	public List<Action> getActionList() {
		return actionList;
	}

	public void setActionList(List<Action> actionList) {
		this.actionList = actionList;
	}	
}
