package com.akash.spring.crm.dao.impl;

import com.akash.spring.crm.dao.CustomerDAO;
import com.akash.spring.crm.dao.queries.Sql;
import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.model.Call;
import com.akash.spring.crm.model.Customer;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Akash Agarwal on 5/2/2016.
 */
public class CustomerDAOImpl implements CustomerDAO{

    private JdbcTemplate jdbcTemplate;

    public CustomerDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTable() {
        try {
            this.jdbcTemplate.update(Sql.Customer.CREATE_TABLE.getSql());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        try {
            this.jdbcTemplate.update(Sql.Customer.CREATE_CALL_TABLE.getSql());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a new customer record.
     *
     * @param customer
     */
    public void create(Customer customer) {
        try {
            this.jdbcTemplate.update(Sql.Customer.INSERT.getSql(),
                    customer.getId(),
                    customer.getCompany(),
                    customer.getEmail(),
                    customer.getTelephone(),
                    customer.getCustomerNotes());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Finds a customer based on their ID
     *
     * @param customerId
     */
    public Customer getById(String customerId) throws CustomerNotFoundException {
        try {
            return this.jdbcTemplate.queryForObject(Sql.Customer.FINDBY_ID.getSql(), new CustomerMapper(), customerId);
        } catch (DataAccessException e) {
            throw new CustomerNotFoundException();
        }
    }

    /**
     * Finds all customers whose company name matches the specified name
     *
     * @param name
     */
    public List<Customer> getByCompanyName(String name) throws CustomerNotFoundException {
        try {
            return this.jdbcTemplate.query(Sql.Customer.FINDBY_COMPANY_NAME.getSql(), new CustomerMapper(), name);
        } catch (DataAccessException e) {
            throw new CustomerNotFoundException();
        }
    }

    /**
     * Updates the specified customer in the database.
     *
     * @param customer
     */
    public void update(Customer customer) throws CustomerNotFoundException {
        try {
            this.jdbcTemplate.update(Sql.Customer.UPDATE.getSql(),
                    customer.getCompany(),
                    customer.getEmail(),
                    customer.getTelephone(),
                    customer.getCustomerNotes(),
                    customer.getId());
        } catch (DataAccessException e) {
            throw new CustomerNotFoundException();
        }
    }

    /**
     * Deletes the specified customer from the database.
     *
     * @param customer
     */
    public void delete(Customer customer) throws CustomerNotFoundException {
        try {
            this.jdbcTemplate.update(Sql.Customer.DELETE.getSql(), customer.getId());
        } catch (DataAccessException e) {
            throw new CustomerNotFoundException();
        }
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
        try {
            return this.jdbcTemplate.query(Sql.Customer.FINDALL.getSql(), new CustomerMapper());
        } catch (DataAccessException e) {
            throw new CustomerNotFoundException();
        }
    }

    /**
     * Returns the full detail for this customer - ie the customer object and ALL
     * calls associated with this customer
     *
     * @param customerId
     */
    public Customer getFullCustomerDetail(String customerId) throws CustomerNotFoundException {
        try {
            Customer customer = this.getById(customerId);
            List<Call> callList = this.jdbcTemplate.query(Sql.Customer.CUSTOMER_CALLS.getSql(), new CallMapper(), customerId);
            customer.setCustomerCalls(callList);
            return customer;
        } catch (DataAccessException e) {
            throw new CustomerNotFoundException();
        }
    }

    /**
     * Links the specifed call to the customer in the database.
     *
     * @param call
     * @param customerId
     */
    public void addCall(Call call, String customerId) throws CustomerNotFoundException {
        try {
            Customer customer = this.getById(customerId);
            this.jdbcTemplate.update(Sql.Customer.ADD_CALL.getSql(), call.getCallNotes(), call.getCallTime(), customerId);
        } catch (DataAccessException e) {
            throw new CustomerNotFoundException();
        }
    }

    private class CustomerMapper implements RowMapper<Customer> {

        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setId(rs.getString("CUSTOMER_ID"));
            customer.setEmail(rs.getString("EMAIL"));
            customer.setTelephone(rs.getString("TELEPHONE"));
            customer.setCustomerNotes(rs.getString("NOTES"));
            customer.setCompany(rs.getString("COMPANY_NAME"));
            return customer;
        }
    }

    private class CallMapper implements RowMapper<Call> {

        public Call mapRow(ResultSet rs, int rowNum) throws SQLException {
            Call call = new Call();
            call.setCallNotes(rs.getString("NOTES"));
            call.setCallTime(rs.getDate("TIME_AND_DATE"));
            return call;
        }
    }
}
