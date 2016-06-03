//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.03 at 02:57:50 PM EDT 
//

package com.akash.spring.crm.webservices.soap.xml.customers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.akash.spring.crm.model.Customer;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customer" type="{http://www.akash.com/crm/customers}customer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "customer" })
@XmlRootElement(name = "getCustomerByIdResponse")
public class GetCustomerByIdResponse {

	@XmlElement(required = true)
	protected CustomerXML customer;

	public GetCustomerByIdResponse() {}

	public GetCustomerByIdResponse(Customer customer) {
		this.customer = new CustomerXML();
		this.customer.setCompany(customer.getCompany());
		this.customer.setCustomerNotes(customer.getCustomerNotes());
		this.customer.setEmail(customer.getEmail());
		this.customer.setId(customer.getId());
		this.customer.setTelephone(customer.getTelephone());
	}

	/**
	 * Gets the value of the customer property.
	 * 
	 * @return possible object is {@link CustomerXML }
	 * 
	 */
	public CustomerXML getCustomer() {
		return customer;
	}

	/**
	 * Sets the value of the customer property.
	 * 
	 * @param value
	 *            allowed object is {@link CustomerXML }
	 * 
	 */
	public void setCustomer(CustomerXML value) {
		this.customer = value;
	}

}
