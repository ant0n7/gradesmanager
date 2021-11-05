package com.google;/*
 *  ===============================================
 *  Project:        Grades_Manager
 *  Program:        First Program
 *  Description:    Hello World
 *  Author:         anton
 *  Date:           05.11.2021
 *  ===============================================
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Semester class to manage all subjects and their grades in a single object.
 * @author anton
 */
public class Semester {
    private String title;
    private List<Subject> subjects;

    public Semester(String title) {
        this.title = title;
        this.subjects = new ArrayList<>();
    }

    public Semester(String title, List<Subject> subjects) {
        this.title = title;
        this.subjects = subjects;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    // Class Methods

    public double getAverage() {
        return 0;
    }

    public boolean getPromotion() {
        return true;
    }
}
