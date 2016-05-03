package com.akash.spring.crm.services.diary.impl;

import com.akash.spring.crm.dao.ActionDAO;
import com.akash.spring.crm.exceptions.RecordNotFoundException;
import com.akash.spring.crm.model.Action;
import com.akash.spring.crm.services.diary.DiaryService;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Created by Akash Agarwal on 5/3/2016.
 */
public class DiaryServiceImpl implements DiaryService {
    private ActionDAO dao;

    public DiaryServiceImpl(ActionDAO dao) {
        this.dao = dao;
    }

    public void recordAction(Action action) {
        try {
            this.dao.create(action);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public List<Action> getAllIncompleteActions(String requiredUser) throws RecordNotFoundException {
        try {
            return this.dao.getIncompleteActions(requiredUser);
        } catch (DataAccessException e) {
            throw new RecordNotFoundException();
        }
    }
}
