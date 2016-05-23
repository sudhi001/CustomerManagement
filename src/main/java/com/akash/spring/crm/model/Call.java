package com.akash.spring.crm.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * Bean that holds details of calls made to the customer
 *
 * Created by Akash Agarwal on 5/2/2016.
 */
@Entity
@Table(name = "TBL_CALL")
public class Call implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * Records the time and date of call.
     */
    private LocalDateTime callTime;

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

    public LocalDateTime getCallTime() {
        return callTime;
    }

    public void setCallTime(LocalDateTime callTime) {
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
