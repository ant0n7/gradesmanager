package com.google;

import ch.google.Output;
import ch.google.Utils;
import ch.google.Color;

import java.io.*;

/**
 * Input Output Handler for project specific tasks
 * Note: Utils library for general utility tools
 * @author anton
 */
public class IO {
    /*
     * DATA SAVING/READING METHODS
     */

    /**
     * Read data from a custom file
     * @param fileName Name of the data file
     * @throws IOException File handling
     * @throws ClassNotFoundException Serialization
     */
    public static GradingManager readData(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(file);

        GradingManager gradingManager = (GradingManager) in.readObject();

        in.close();
        file.close();

        return gradingManager;
    }

    /**
     * Read data from the default data file
     * @throws IOException File handling
     * @throws ClassNotFoundException Serialization
     */
    public static GradingManager readData() throws IOException, ClassNotFoundException {
        return readData("data.properties");
    }

    /**
     * Save data to a custom file
     * @param fileName Name of the data file
     * @throws IOException File handling
     */
    public static void saveToFile(String fileName, GradingManager gradingManager) throws IOException {
        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(file);

        out.writeObject(gradingManager);

        out.close();
        file.close();
    }

    /**
     * Save data to the default data file
     * @throws IOException File handling
     */
    public static void saveToFile(GradingManager gradingManager) throws IOException {
        saveToFile("data.properties", gradingManager);
    }

    public static void printGrade(Grade grade) {
        System.out.println(Color.BOLD + grade.getTitle() + Color.RESET);
        System.out.println(grade.getScore() + " [" + grade.getWeighting() + "]");
    }

    /*
     * SEMESTER METHODS
     */

    /**
     * Print all semesters with their average to the console
     * @param gradingManager Grading manager which contains these semesters
     */
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
            System.out.println(i + " - " + subject.getTitle() + " (" + subject.getAverage() + ")");
        }
    }

    /**
     * Input a new Semester object from the console user
     * @return Semester object created by the user
     */
    public static Semester inputSemester() {
        Output.printBox("Semester Properties");
        String title = Utils.scanString("Title: ");

        return new Semester(title);
    }

    /*
     * SUBJECT METHODS
     */

    /**
     * Print a Subject object to the console
     * @param subject Subject object to print to the console
     */
    public static void printSubject(Subject subject) {
        Output.printBox(subject.getTitle());


        for (Grade grade :
                subject.getGrades()) {
            printGrade(grade);
        }
    }

    /**
     * Input a new Subject object from the console user
     * @return Subject object created by the user
     */
    public static Subject inputSubject() {
        Output.printBox("Subject Properties");
        String title = Utils.scanString("Title: ");

        return new Subject(title);
    }

    /*
     * GRADE METHODS
     */

    /**
     * Input a new Grade object from the console user
     * @return Grade object created by the user
     */
    public static Grade inputGrade() {
        Output.printBox("Grade Properties");
        String title = Utils.scanString("Title: ");
        double score = Utils.scanRangedDouble(1, 6, "Score (1-6): ");
        double weighting = Utils.scanRangedDouble(0, 1000000, "Weighting: ");

        return new Grade(title, score, weighting);
    }

    /*
     * OTHER METHODS
     */

    /**
     * Print the message for an invalid choice to the console
     */
    public static void printInvalidChoice() {
        System.out.println("Invalid Choice");
    }
}
