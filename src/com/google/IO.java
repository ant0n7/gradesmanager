package com.google;

import ch.google.Output;
import ch.google.Utils;
import ch.google.Color;

import java.io.File;
import java.io.IOException;

/**
 * Input Output Handler for project specific tasks
 * Note: Utils library for general utility tools
 * @author anton
 */
public class IO {
    /**
     * Read data from a custom file
     * @param fileName Name of the data file
     * @author anton
     */
    public static void readData(String fileName) throws IOException {
        //
    }

    /**
     * Read data from the default data file
     * @author anton
     */
    public static void readData() throws IOException {
        readData("data.properties");
    }

    public static void printGrade(Grade grade) {
        System.out.println(Color.BOLD + grade.getTitle() + Color.RESET);
        System.out.println(grade.getScore() + " [" + grade.getWeighting() + "]");
    }

    public static void printSubject(Subject subject) {
        Output.printBox(subject.getTitle());


        for (Grade grade :
                subject.getGrades()) {
            printGrade(grade);
        }
    }

    public static void printSemesters(GradingManager gradingManager) {
        Output.printBox("Semesters");

        for (int i = 0; i < gradingManager.getSemesters().size(); i++) {
            Semester semester = gradingManager.getSemesters().get(i);
            System.out.println(i + " - " + semester.getTitle() + " (" + semester.getAverage() + ")");
        }
    }

    /**
     * Print all subjects of a semester with their average
     * @param semester Semester whose subjects are printed
     */
    public static void printSemester(Semester semester) {
        Output.printBox(semester.getTitle() + " Subjects");

        for (int i = 0; i < semester.getSubjects().size(); i++) {
            Subject subject = semester.getSubjects().get(i);
            System.out.println(i + " - " + subject + " (" + subject.getAverage() + ")");
        }
    }

    public static Semester inputSemester() {
        Output.printBox("Semester Properties");
        String title = Utils.scanString("Title: ");

        return new Semester(title);
    }

    public static void printInvalidChoice() {
        System.out.println("Invalid Choice");
    }

    public static Subject inputSubject() {
        Output.printBox("Subject Properties");
        String title = Utils.scanString("Title: ");

        return new Subject(title);
    }

    public static Grade inputGrade() {
        Output.printBox("Grade Properties");
        String title = Utils.scanString("Title: ");
        double score = Utils.scanRangedDouble(1, 6, "Score (1-6): ");
        double weighting = Utils.scanRangedDouble(0, 1000000, "Weighting: ");

        return new Grade(title, score, weighting);
    }
}
