package com.google;/*
 *  ===============================================
 *  Project:        Grades_Manager
 *  Program:        First Program
 *  Description:    Hello World
 *  Author:         anton
 *  Date:           05.11.2021
 *  ===============================================
 */

import ch.google.Output;

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

    public void manage() {
        while (true) {
            printSemester();
            Output.printMenu(Output.SUB_MENU, title, "1 - View Subjects", "2 - Add Subjects", "3 - Remove Subjects", "4 - Rename Subjects", "0 - Exit");

            break;
        }
    }

    public double getAverage() {
        return 0;
    }

    public boolean getPromotion() {
        return true;
    }

    private void printSemester() {
        IO.printSemester(this);
    }
}
