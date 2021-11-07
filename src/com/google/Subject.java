package com.google;

import ch.google.Output;
import ch.google.Utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Manage subjects with grades and more. Usually for implementation in a Semester-object.
 *
 * @author anton
 */
public class Subject implements Serializable {
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

    /**
     * Calculate the average of all grades
     * @return Average or 0 (if no grades are available)
     */
    public double getAverage() {
        double sumScoresWithWeights = 0;
        double sumWeights = 0;

        for (Grade grade :
                getGrades()) {
            sumWeights += grade.getWeighting();
            sumScoresWithWeights += grade.getScore() * grade.getWeighting();
        }

        return sumScoresWithWeights > 0.0 ? sumScoresWithWeights / sumWeights : 0.0;
    }

    /**
     * Print managing menu to manage the subject
     */
    public void manage() {
        while (true) {
            String tempTitle = getTitle().length() < 9 ? " ".repeat(8) + getTitle() + " ".repeat(8) : getTitle();
            Output.printMenu(Output.MAIN_MENU, tempTitle, "1 - View Grades", "2 - Add Grade", "3 - Remove Grade", "4 - Rename Grade", "0 - Exit");
            int choice = Utils.scanRangedInt(0, 4, "\t- ");

            int index; // for use in some cases of the switch
            switch (choice) {
                case 0:
                    return;
                case 1:
                    IO.printSubject(this);
                    break;
                case 2:
                    addGrade(IO.inputGrade());
                    break;
                case 3:
                    index = Utils.scanRangedInt(0, getGrades().size() - 1, "Grade Index: ");
                    removeGrade(index);
                    break;
                case 4:
                    index = Utils.scanRangedInt(0, getGrades().size() - 1, "Grade Index: ");
                    String newTitle = Utils.scanString("New Title: ");
                    renameGrade(index, newTitle);
                    break;
                default:
                    IO.printInvalidChoice();
            }
        }
    }

    /**
     * Add a grade to the grade list
     * @param grade Grade object to add
     */
    private void addGrade(Grade grade) {
        getGrades().add(grade);
    }

    /**
     * Rename a grade
     * @param index Index of the grade object to rename
     * @param newTitle New title for the grade
     */
    private void renameGrade(int index, String newTitle) {
        getGrades().get(index).setTitle(newTitle);
    }

    /**
     * Remove a grade from the grade list
     * @param index Index to remove
     */
    private void removeGrade(int index) {
        getGrades().remove(index);
    }

    /**
     * Print a subject to the console
     */
    public void print() {
        IO.printSubject(this);
    }
}
