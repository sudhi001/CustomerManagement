package com.akash.spring.crm.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Bean holding customer details.
 *
 * Created by Akash Agarwal on 5/2/2016.
 */
@Entity
@XmlRootElement// (For REST WebService)
public class Customer implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Uniqure CustomerID provided.
     */
    @Id
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
    @OneToMany(/*fetch = FetchType.EAGER, */cascade = CascadeType.ALL)
    private List<Call> calls;

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

    public List<Call> getCalls() {
        return calls;
    }

    public void setCalls(List<Call> calls) {
        this.calls = calls;
    }

    /**
     * Add a new call to the customer
     */
    public void addCall(Call call) {
        this.calls.add(call);
    }

    @Override
    public String toString() {
        return this.id + ": " + this.company;
    }
}
