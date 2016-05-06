package com.akash.spring.crm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Bean to hold the action to be carried out.
 *
 * Created by Akash Agarwal on 5/2/2016.
 */
@Entity
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * Details of action
     */
    private String details;

    /**
     * Required Date and Time
     */
    private Calendar requiredBy;

    /**
     * Owner of the action
     */
    private String owner;

    /**
     * Checks if action is complete
     */
    private boolean complete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Calendar getRequiredBy() {
        return requiredBy;
    }

    public void setRequiredBy(Calendar requiredBy) {
        this.requiredBy = requiredBy;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    /**
     * Completes the Action
     */
    public void completeAction() {
        this.complete = true;
    }

    /**
     * Checks if action is Overdue
     */
    public boolean isOverdue() {
        Calendar dateNow = new GregorianCalendar();
        return dateNow.after(this.requiredBy);
    }

    @Override
    public String toString() {
        return "Action for " + this.owner + ": " + this.details + ", required by " + this.requiredBy.getTime();
    }
}
