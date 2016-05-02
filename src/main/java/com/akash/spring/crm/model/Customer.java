package com.akash.spring.crm.model;

import java.util.List;

/**
 * Bean holding customer details.
 *
 * Created by Akash Agarwal on 5/2/2016.
 */
public class Customer {

    /**
     * Uniqure CustomerID provided.
     */
    private String id;

    /**
     * Customer's company name
     */
    private String company;

    /**
     * Customer's email address
     */
    private String email;

    /**
     * Customer's telephone number
     */
    private String telephone;

    /**
     * Customer's associated notes
     */
    private String customerNotes;

    /**
     * Calls made to the customer
     */
    private List<Call> customerCalls;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCustomerNotes() {
        return customerNotes;
    }

    public void setCustomerNotes(String customerNotes) {
        this.customerNotes = customerNotes;
    }

    public List<Call> getCustomerCalls() {
        return customerCalls;
    }

    public void setCustomerCalls(List<Call> customerCalls) {
        this.customerCalls = customerCalls;
    }

    /**
     * Add a new call to the customer
     */
    public void addCall(Call call) {
        this.customerCalls.add(call);
    }

    @Override
    public String toString() {
        return this.id + ": " + this.company;
    }
}
