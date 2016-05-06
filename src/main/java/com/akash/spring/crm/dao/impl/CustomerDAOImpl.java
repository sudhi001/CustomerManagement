package com.akash.spring.crm.dao.impl;

import com.akash.spring.crm.dao.CustomerDAO;
import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.model.Call;
import com.akash.spring.crm.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Akash Agarwal on 5/2/2016.
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Creates a new customer record.
     *
     * @param customer
     */
    public void create(Customer customer) {
        entityManager.persist(customer);
    }

    /**
     * Finds a customer based on their ID
     *
     * @param id
     */
    public Customer getById(String id) throws CustomerNotFoundException {
        return (Customer) entityManager.createQuery("select customer from Customer as customer where customer.id=:id")
                .setParameter("id", id)
                .getSingleResult();
    }

    /**
     * Finds all customers whose company name matches the specified name
     *
     * @param company
     */
    public List<Customer> getByCompanyName(String company) throws CustomerNotFoundException {
        return entityManager.createQuery("select customer from Customer as customer where customer.company=:company")
                .setParameter("company", company)
                .getResultList();
    }

    /**
     * Updates the specified customer in the database.
     *
     * @param customer
     */
    public void update(Customer customer) throws CustomerNotFoundException {
        entityManager.merge(customer);
    }

    /**
     * Deletes the specified customer from the database.
     *
     * @param customer
     */
    public void delete(Customer customer) throws CustomerNotFoundException {
        entityManager.remove(this.getById(customer.getId()));
    }

    /**
     * Returns a complete collection of customer objects. Note that it is NOT necessary
     * to for this method to also return the associated calls (ie getCalls() will return null).
     * <p>
     * This is for efficiency reasons - we may not be interested in the calls for ALL customers
     * in ths system.
     *
     * @return
     */
    public List<Customer> findAll() throws CustomerNotFoundException {
        return entityManager.createQuery("select customer from Customer as customer").getResultList();
    }

    /**
     * Returns the full detail for this customer - ie the customer object and ALL
     * calls associated with this customer
     *
     * @param id
     */
    public Customer getFullCustomerDetail(String id) throws CustomerNotFoundException {
        return (Customer) entityManager.createQuery("select customer from Customer as customer left join fetch customer.calls where customer.id=?")
                .setParameter("id", id)
                .getSingleResult();
    }

    /**
     * Links the specifed call to the customer in the database.
     *
     * @param call
     * @param id
     */
    public void addCall(Call call, String id) throws CustomerNotFoundException {
        Customer customer = entityManager.find(Customer.class, id);
        customer.addCall(call);
    }
}
