package com.akash.spring.crm.services.diary.impl;

import com.akash.spring.crm.model.Action;
import com.akash.spring.crm.services.diary.DiaryService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Akash Agarwal on 5/3/2016.
 */
public class DiaryServiceImpl implements DiaryService {
    private Set<Action> actions = new HashSet<Action>();

    public void recordAction(Action action) {
        actions.add(action);
    }

    public List<Action> getAllIncompleteActions(String requiredUser) {
        List<Action> actionList = new ArrayList<Action>();
        for (Action next : actions) {
            if ((next.getOwner().equalsIgnoreCase(requiredUser)) && (!next.isComplete())) {
                actionList.add(next);
            }
        }
        return actionList;
    }
}
