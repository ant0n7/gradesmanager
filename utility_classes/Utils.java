package ch.google;/*
 *  ===============================================
 *  Project:        Utils
 *  Program:        First Program
 *  Description:    Hello World
 *  Author:         anton
 *  Date:           03.02.2021
 *  ===============================================
 */

import java.util.Scanner;

public class Utils {
    public static void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        promptKey();
    }

    public static void promptEnterKey(String msg) {
        System.out.print(msg);
        promptKey();
    }

    private static void promptKey() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static int scanRangedInt(int min, int max) {
        int num;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.print("Enter a number between " + min + " and " + max + " -- " );
            while (!scan.hasNextInt()) {
                System.out.println("Invalid Number");
                System.out.print("Enter a number between " + min + " and " + max + " -- " );
                scan.next();
            }
            num = scan.nextInt();
        } while (num < min || num > max);

        return num;
    }

    public static int scanRangedInt(int min, int max, String text) {
        int num;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.print(text);
            while (!scan.hasNextInt()) {
                System.out.println("Invalid Number");
                System.out.print("Enter a number between " + min + " and " + max + " -- " );
                scan.next();
            }
            num = scan.nextInt();
        } while (num < min || num > max);

        return num;
    }

    public static double scanRangedDouble(double min, double max, String text) {
        double num;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.print(text);
            while (!scan.hasNextDouble()) {
                System.out.println("Invalid Number");
                System.out.print("Enter a number between " + min + " and " + max + " -- " );
                scan.next();
            }
            num = scan.nextDouble();
        } while (num < min || num > max);

        return num;
    }

    public static int scanInt() {
        int num;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a number: ");
        while (!scan.hasNextInt()) {
            System.out.println("Invalid Number");
            scan.next();
        }
        num = scan.nextInt();

        return num;
    }

    public static int scanInt(String text) {
        int num;
        Scanner scan = new Scanner(System.in);

        System.out.print(text);
        while (!scan.hasNextInt()) {
            System.out.println("Invalid Number");
            scan.next();
        }
        num = scan.nextInt();

        return num;
    }

    public static String scanString() {
        String str;
        Scanner scan = new Scanner(System.in);

        System.out.print("");
        while (!scan.hasNextLine()) {
            System.out.println("Invalid Input");
            scan.next();
        }
        str = scan.nextLine();

        return str;
    }

    public static String scanString(String text) {
        String str;
        Scanner scan = new Scanner(System.in);

        System.out.print(text);
        while (!scan.hasNextLine()) {
            System.out.println("Invalid Input");
            scan.next();
        }
        str = scan.nextLine();

        return str;
    }

    public static String scanSingleWord() {
        String str;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a word -- only first word will be used ");
        while (!scan.hasNext()) {
            System.out.println("Invalid Input");
            scan.next();
        }
        str = scan.next();

        return str;
    }

    public static String scanSingleWord(String text) {
        String str;
        Scanner scan = new Scanner(System.in);

        System.out.print(text);
        while (!scan.hasNext()) {
            System.out.println("Invalid Input");
            scan.next();
        }
        str = scan.next();

        return str;
    }

    public static char scanChar() {
        char c;
        Scanner scan = new Scanner(System.in);
        int min = 32, max = 126;

        do {
            System.out.println("Enter a character");
            while (!scan.hasNextInt()) {
                System.out.println("Invalid Character");
                scan.next();
            }
            c = scan.next().charAt(0);
        } while (c < min || c > max);

        return c;
    }

    public static char scanChar(String text) {
        char c;
        Scanner scan = new Scanner(System.in);
        int min = 32, max = 126;

        do {
            System.out.print(text);
            while (!scan.hasNext()) {
                System.out.println("Invalid Character");
                scan.next();
            }
            c = scan.next().charAt(0);
        } while (((int) c) < min || ((int) c) > max);

        return c;
    }

    public static char scanLetter() {
        char c;
        Scanner scan = new Scanner(System.in);
        int min = 65, max = 90;
        int min2 = 97, max2 = 122;

        do {
            System.out.print("Enter a letter: ");
            while (!scan.hasNext()) {
                System.out.println("Invalid Character");
                scan.next();
            }
            c = scan.next().charAt(0);
        } while ((c < min2 && c > max) || c < min || c > max2);

        return c;
    }

    public static char scanLetter(String text) {
        char c;
        Scanner scan = new Scanner(System.in);
        int min = 65, max = 90;
        int min2 = 97, max2 = 122;

        do {
            System.out.print(text);
            while (!scan.hasNext()) {
                System.out.println("Invalid Character");
                scan.next();
            }
            c = scan.next().charAt(0);
        } while ((c < min2 && c > max) || c < min || c > max2);

        return c;
    }

    public static String removeSpecialCharacter(String str) { return str.replaceAll("[^a-zA-Z0-9]", ""); }

    public static String scanAlphabeticString() {
        String str;
        Scanner scan = new Scanner(System.in);
        boolean correctString = false;
        do {

            str = scan.nextLine();
            for (int i = 0; i < str.length(); i++) {
                if ((str.charAt(i) >= 97 && str.charAt(i) <= 122)||(str.charAt(i) >= 65 && str.charAt(i) <= 90)){
                    correctString = true;
                } else {
                    correctString = false;
                    System.out.println("Input is invalid");
                    System.out.println("Enter a valid String without numbers or special characters");
                    break;
                }
            }
        } while (!correctString);
        return str;
    }

    public static String scanAlphabeticString(String text) {
        String str;
        Scanner scan = new Scanner(System.in);
        boolean correctString = false;
        do {
            System.out.print(text);
            str = scan.nextLine();
            for (int i = 0; i < str.length(); i++) {
                if ((str.charAt(i) >= 97 && str.charAt(i) <= 122)||(str.charAt(i) >= 65 && str.charAt(i) <= 90)){
                    correctString = true;
                } else {
                    correctString = false;
                    System.out.println("Input is invalid");
                    break;
                }
            }
        } while (!correctString);
        return str;
    }

    public static void newLine(int n) { for (int i = 0; i < n; i++) { System.out.print("\n"); } }

    public static void printLine(int n, String sign) {
        for (int i = 0; i < n; i++) {
            System.out.print(sign);
        }
        System.out.print("\n");
    }

    public static void printLine(String sign) {
        for (int i = 0; i < 25; i++) {
            System.out.print(sign);
        }
        System.out.print("\n");
    }
}
