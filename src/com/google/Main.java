package com.google;

import java.io.IOException;

/**
 * Main class to start the program
 * Note: Contains no logic
 * @author anton
 */
public class Main {

    public static void main(String[] args) {
        /*
         if data saving doesn't work (also for first run with a new file: remove all code from main and use following lines:

         GradingManager gm = new GradingManager();
         gm.start();
         */
        GradingManager gm = null;
        try {
            gm = IO.readData();
        } catch (IOException e) {
            System.out.println("IO Error.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class Error.");
            e.printStackTrace();
        }

        assert gm != null;
        gm.start();

        try {
            IO.saveToFile(gm);
            System.out.println("Data saved.");
        } catch (IOException e) {
            System.out.println("Data not saved.");
            e.printStackTrace();
        }
    }
}
