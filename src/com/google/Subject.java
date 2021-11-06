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
 * Manage subjects with grades and more. Usually for implementation in a Semester-object.
 *
 * @author anton
 */
public class Subject {
    private String title;
    private List<Grade> grades;

    public Subject(String title) {
        this.title = title;
        this.grades = new ArrayList<>();
    }

    public Subject(String title, List<Grade> grades) {
        this.title = title;
        this.grades = grades;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    // Class Methods
    public double getAverage() {
        return 0;
    }

    public void manage() {
        // TODO
    }
}
