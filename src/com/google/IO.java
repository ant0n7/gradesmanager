package com.google;

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
}
