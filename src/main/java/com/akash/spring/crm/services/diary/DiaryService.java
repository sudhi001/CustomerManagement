package com.akash.spring.crm.services.diary;

import com.akash.spring.crm.model.Action;

import java.util.List;

/**
 * This interface defines the functionality required in the Diary Management Service.
 *
 * Created by Akash Agarwal on 5/2/2016.
 */
public interface DiaryService {

    /**
     * Records an action in the diary
     */
    void recordAction(Action action);

    /**
     * Gets all actions for a particular user that have not yet been complete
     */
    List<Action> getAllIncompleteActions(String requiredUser);
}
