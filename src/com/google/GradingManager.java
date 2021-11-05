package com.google;

import java.util.List;

/**
 * Class to manage semesters with their subjects and grades.
 * @author anton
 */
public class GradingManager {
    private List<Semester> semesters;

    public GradingManager(List<Semester> semesters) {
        this.semesters = semesters;
    }

    public List<Semester> getSemesters() {
        return semesters;
    }

    public void setSemesters(List<Semester> semesters) {
        this.semesters = semesters;
    }
}
