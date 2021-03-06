package com.google;/*
 *  ===============================================
 *  Project:        Grades_Manager
 *  Program:        First Program
 *  Description:    Hello World
 *  Author:         anton
 *  Date:           05.11.2021
 *  ===============================================
 */

import java.io.Serializable;

/**
 * Manage grades. Usually for implementation in a Subject-object.
 *
 * @author anton
 */
public class Grade implements Serializable {
    private String title;
    private double score;
    private double weighting;

    public Grade(String title, double score, double weighting) {
        this.title = title;
        this.score = score;
        this.weighting = weighting;
    }

    /**
     * Getter for {@link Grade#title}
     * @return Title of the grade
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for {@link Grade#title}
     * @param title {@link Grade#title} of the grade
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getWeighting() {
        return weighting;
    }

    public void setWeighting(double weighting) {
        this.weighting = weighting;
    }

    /**
     * Print a grade to the console
     */
    public void print() {
        IO.printGrade(this);
    }
}
