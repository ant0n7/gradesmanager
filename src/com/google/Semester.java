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
import ch.google.Utils;

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
            Output.printMenu(Output.SUB_MENU, title, "1 - View Subjects", "2 - Add Subjects", "3 - Remove Subjects", "4 - Rename Subjects", "0 - Exit");
            int choice = Utils.scanRangedInt(0, 4, "\t- ");

            int index; // for use in some cases of the switch
            switch (choice) {
                case 0:
                    return;
                case 1:
                    printSemester();
                    break;
                case 2:
                    index = Utils.scanRangedInt(0, getSubjects().size() - 1, "Subject Index: ");
                    getSubjects().get(index).manage();
                case 3:
                    addSubject(IO.inputSubject());
                    break;
                case 4:
                    index = Utils.scanRangedInt(0, getSubjects().size() - 1, "Subject Index: ");
                    removeSubject(index);
                    break;
                case 5:
                    index = Utils.scanRangedInt(0, getSubjects().size() - 1, "Subject Index: ");
                    String newTitle = Utils.scanString("New Title: ");
                    renameSubject(index, newTitle);
                    break;
                default:
                    IO.printInvalidChoice();
            }
            break;
        }
    }

    private void renameSubject(int index, String newTitle) {
        getSubjects().get(index).setTitle(newTitle);
    }

    private void removeSubject(int index) {
        getSubjects().remove(index);
    }

    private void addSubject(Subject subject) {
        getSubjects().add(subject);
    }

    public double getAverage() {
        // TODO: issues/9
        return 0;
    }

    public boolean getPromotion() {
        // TODO: issues/9
        return true;
    }

    private void printSemester() {
        IO.printSemester(this);
    }
}
