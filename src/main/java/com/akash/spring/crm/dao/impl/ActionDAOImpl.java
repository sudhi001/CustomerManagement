package com.akash.spring.crm.dao.impl;

import com.akash.spring.crm.dao.ActionDAO;
import com.akash.spring.crm.dao.queries.Sql;
import com.akash.spring.crm.exceptions.RecordNotFoundException;
import com.akash.spring.crm.model.Action;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Akash Agarwal on 5/3/2016.
 */
public class ActionDAOImpl implements ActionDAO {

    private JdbcTemplate jdbcTemplate;

    public ActionDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private void createTable() {
        try {
            this.jdbcTemplate.update(Sql.Action.CREATE_TABLE.getSql());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void create(Action action) {
        try {
            this.jdbcTemplate.update(Sql.Action.INSERT.getSql(), action.getDetails(), action.isComplete(), action.getOwner(), action.getRequiredBy());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public List<Action> getIncompleteActions(String userId) throws RecordNotFoundException {
        try {
            return this.jdbcTemplate.query(Sql.Action.INCOMPLETE.getSql(), new ActionMapper(), userId);
        } catch (DataAccessException e) {
            throw new RecordNotFoundException();
        }
    }

    public void update(Action action) throws RecordNotFoundException {
        try {
            this.jdbcTemplate.update(Sql.Action.UPDATE.getSql(), action.getDetails(), action.isComplete(), action.getOwner(), action.getRequiredBy().getTime(), action.getId());
        } catch (DataAccessException e) {
            throw new RecordNotFoundException();
        }
    }

    public void delete(Action action) throws RecordNotFoundException {
        try {
            this.jdbcTemplate.update(Sql.Action.DELETE.getSql(), action.getId());
        } catch (DataAccessException e) {
            throw new RecordNotFoundException();
        }
    }

    private class ActionMapper implements RowMapper<Action> {

        public Action mapRow(ResultSet rs, int rowNum) throws SQLException {
            Action action = new Action();
            action.setId(rs.getInt("ACTION_ID"));
            action.setOwner(rs.getString("OWNING_USER"));
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(rs.getDate("REQUIRED_BY"));
            action.setRequiredBy(calendar);
            action.setDetails(rs.getString("DETAILS"));
            action.setComplete(rs.getBoolean("COMPLETE"));
            return action;
        }
    }
}
