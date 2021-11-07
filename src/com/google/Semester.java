package com.google;

import ch.google.Output;
import ch.google.Utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Semester class to manage all subjects and their grades in a single object.
 * @author anton
 */
public class Semester implements Serializable {
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

    /**
     * Print managing menu to manage the semester
     */
    public void manage() {
        while (true) {
            String tempTitle = getTitle().length() < 9 ? " ".repeat(8) + getTitle() + " ".repeat(8) : getTitle();
            Output.printMenu(Output.MAIN_MENU, tempTitle, "1 - View Subjects", "2 - Select Subject", "3 - Add Subjects", "4 - Remove Subjects", "5 - Rename Subjects", "0 - Exit");
            int choice = Utils.scanRangedInt(0, 5, "\t- ");

            int index; // for use in some cases of the switch
            switch (choice) {
                case 0:
                    return;
                case 1:
                    IO.printSemester(this);
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
        }
    }

    /**
     * Rename a subject
     * @param index Index of the subject object to rename
     * @param newTitle New title for the subject
     */
    private void renameSubject(int index, String newTitle) {
        getSubjects().get(index).setTitle(newTitle);
    }

    /**
     * Remove a subject from the subject list
     * @param index Index to remove
     */
    private void removeSubject(int index) {
        getSubjects().remove(index);
    }

    /**
     * Add a subject to the subject list
     * @param subject Subject object to add
     */
    private void addSubject(Subject subject) {
        getSubjects().add(subject);
    }

    /**
     * Calculate the average of all subjects
     * Average is rounded to 0.5
     * @return Rounded average or 0 (if no subjects are available)
     */
    public double getAverage() {
        double sumAverages = 0;
        int gradedSubjects = 0;

        for (Subject subject : getSubjects()) {
            if (subject.getAverage() > 0.0) {
                gradedSubjects++;
                sumAverages += Math.round(subject.getAverage() * 2) / 2.0;
            }
        }

        return gradedSubjects > 0 ? sumAverages / getSubjects().size() : 0;
    }

    /**
     * Checks if the semester is passed
     * @return Promotion (true = passed; false = failed)
     */
    public boolean getPromotion() {
        return getAverage() >= 4;
    }

    /**
     * Print semester to the console
     */
    public void print() {
        IO.printSemester(this);
    }
}
