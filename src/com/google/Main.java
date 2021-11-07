package com.google;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
//        GradingManager gm = new GradingManager();
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
