package com.example.universitylife.CourseSelector;

import com.example.universitylife.IData;
import com.example.universitylife.GameManager;

public class CourseSelectorPresenter {
    private ICourseSelector.ICourseSelectorView view;
    private GameManager gameManager;

    CourseSelectorPresenter(ICourseSelector.ICourseSelectorView view, IData dataHandler, String username) {
        this.view = view;
        gameManager = new GameManager(dataHandler, username);
    }

    int getPicIndex() {
        return gameManager.getCurrentStudent().getAppearance();
    }

    /**
     * return the current student name.
     *
     * @return the current student name.
     */
    public String getUsername() {
        return gameManager.getCurrentUsername();
    }

}
