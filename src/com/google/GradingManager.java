package com.google;

import ch.google.Output;
import ch.google.Utils;

import java.util.ArrayList;
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

    public GradingManager() {
        this.semesters = new ArrayList<>();
    }

    public List<Semester> getSemesters() {
        return semesters;
    }

    public void setSemesters(List<Semester> semesters) {
        this.semesters = semesters;
    }

    /**
     * Start the Grading Manager
     */
    public void start() {
        while (true) {
            Output.printMenu(Output.MAIN_MENU, "Grading Manager", "1 - View Semesters", "2 - Select Semester", "3 - Add Semesters", "4 - Remove Semesters", "5 - Rename Semesters", "0 - Exit");
            int choice = Utils.scanRangedInt(0, 5, "\t- ");

            int index; // for use in some cases of the switch
            switch (choice) {
                case 0:
                    return;
                case 1:
                    IO.printSemesters(this);
                    break;
                case 2:
                    index = Utils.scanRangedInt(0, getSemesters().size() - 1, "Semester Index: ");
                    getSemesters().get(index).manage();
                case 3:
                    addSemester(IO.inputSemester());
                    break;
                case 4:
                    index = Utils.scanRangedInt(0, getSemesters().size() - 1, "Semester Index: ");
                    removeSemester(index);
                    break;
                case 5:
                    index = Utils.scanRangedInt(0, getSemesters().size() - 1, "Semester Index: ");
                    String newTitle = Utils.scanString("New Title: ");
                    renameSemester(index, newTitle);
                    break;
                default:
                    IO.printInvalidChoice();
            }
        }
    }

    /**
     * Add a semester to the semester list
     * @param semester Semester object to add
     */
    private void addSemester(Semester semester) {
        getSemesters().add(semester);
    }

    /**
     * Remove a semester from the semester list
     * @param index Index of the semester to remove
     */
    private void removeSemester(int index) {
        getSemesters().remove(index);
    }

    /**
     * Rename a semester
     * @param index Index of the semester to rename
     * @param newTitle New Title to be set
     */
    private void renameSemester(int index, String newTitle) {
        getSemesters().get(index).setTitle(newTitle);
    }
}
