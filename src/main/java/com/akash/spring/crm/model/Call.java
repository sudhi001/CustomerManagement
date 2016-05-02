package com.akash.spring.crm.model;

import java.util.Date;

/**
 *
 * Bean that holds details of calls made to the customer
 *
 * Created by Akash Agarwal on 5/2/2016.
 */
public class Call {

    private int id;

    /**
     * Records the time and date of call.
     */
    private Date callTime;

    /**
     * Notes about the call.
     */
    private String callNotes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCallTime() {
        return callTime;
    }

    public void setCallTime(Date callTime) {
        this.callTime = callTime;
    }

    public String getCallNotes() {
        return callNotes;
    }

    public void setCallNotes(String callNotes) {
        this.callNotes = callNotes;
    }

    @Override
    public String toString() {
        return this.callTime + " : " + this.callNotes;
    }
}
