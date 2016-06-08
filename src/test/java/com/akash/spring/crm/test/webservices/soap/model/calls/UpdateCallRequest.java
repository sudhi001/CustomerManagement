
package com.akash.spring.crm.test.webservices.soap.model.calls;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="call" type="{http://www.akash.com/crm/calls}call"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "call"
})
@XmlRootElement(name = "updateCallRequest")
public class UpdateCallRequest {

    @XmlElement(required = true)
    protected Call call;

    /**
     * Gets the value of the call property.
     * 
     * @return
     *     possible object is
     *     {@link Call }
     *     
     */
    public Call getCall() {
        return call;
    }

    /**
     * Sets the value of the call property.
     * 
     * @param value
     *     allowed object is
     *     {@link Call }
     *     
     */
    public void setCall(Call value) {
        this.call = value;
    }

}
