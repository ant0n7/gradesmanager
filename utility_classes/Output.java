package ch.google;/*
 *  ===============================================
 *  Project:        Utils
 *  Program:        First Program
 *  Description:    Hello World
 *  Author:         anton
 *  Date:           17.03.2021
 *  ===============================================
 */

public final class Output {
    public enum ListType {
        ORDERED, UNORDERED
    }
    public static void printLine(String sign) {
        for (int i = 0; i < 25; i++) {
            System.out.print(sign);
        }
        System.out.print("\n");
    }

    public static void newLine(int n) { for (int i = 0; i < n; i++) { System.out.print("\n"); } }

    public static void printBox(String... texts) {
        for (String text : texts) {
            int length = text.length();
            String verticalLine = "┬─" + ("─".repeat(length)) + "─";

            System.out.print(verticalLine);
        }
        System.out.print("┬\n");

        for (String text : texts) {
            System.out.print("│ " + text + " ");
        }
        System.out.print("│\n");

        for (String text : texts) {
            int length = text.length();
            String verticalLine = "┴─" + ("─".repeat(length)) + "─";

            System.out.print(verticalLine);
        }
        System.out.print("┴\n");
    }

    public static void printList(ListType listType, String... args) {
        int brightness = 242;
        switch (listType) {
            case ORDERED:
                int count = 1;
                String formattedString;
                String formattedNumber;
                for (String str : args) {
                    formattedNumber = String.format("%d.", count);
                    formattedString = String.format(" %-3s", formattedNumber);
                    System.out.println(Color.ANSI_BEFORE_TEXT + brightness + Color.ANSI_AFTER + formattedString + Color.RESET + "" + str);
                    count++;
                }

                break;
            case UNORDERED:
                for (String str : args) {
                    System.out.println(Color.ANSI_BEFORE_TEXT + brightness + Color.ANSI_AFTER + " - " + Color.RESET + str);
                }
                break;
        }
    }

    public final static int MAIN_MENU = 1;
    public static final int SUB_MENU = 2;

    /**
     * @param menuLevel Pass the menu level for better appereance.
     *                  1 = main menu (stronger border)
     *                  2 = sub menu (stronger border)
     * @param title Title of the menu, shown at the top
     * @param args Menu Selection
     */
    public static void printMenu(int menuLevel, String title, String... args) {
        // 1 = Hauptmenu (fat), 2 = Sub Menu (double striped), 3 = single
//        System.out.println("████████████████████████████████████████");
//        System.out.println("█                                      █");
//        System.out.println("█                                      █");
//        System.out.println("█                                      █");
//        System.out.println("▉                                      █");
//        System.out.println("████████████████████████████████████████");

//
//        System.out.println("▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜");
//        System.out.println("▌                                       ▐");
//        System.out.println("▌                                       ▐");
//        System.out.println("▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟");

        switch (menuLevel) {
            case 1:
                printMainMenu(title, args);
                break;
            case 2:
                printSubMenu(title, args);
        }


    }

    private static void printSubMenu(String title, String[] options) {
        int width = title.length() * 2;
        String verticalLineUpper = BOX_DOUBLE.CORNER_LEFT_UPPER + (BOX_DOUBLE.HORIZONTAL + "").repeat(width - 2) + BOX_DOUBLE.CORNER_RIGHT_UPPER;
        String verticalLineLower = BOX_DOUBLE.CORNER_LEFT_LOWER + (BOX_DOUBLE.HORIZONTAL + "").repeat(width - 2) + BOX_DOUBLE.CORNER_RIGHT_LOWER;
        String verticalLineMiddle = BOX_DOUBLE.CROSS_HALF_RIGHT + (BOX_DOUBLE.HORIZONTAL + "").repeat(width - 2) + BOX_DOUBLE.CROSS_HALF_LEFT;

        System.out.print(verticalLineUpper + "\n");
        System.out.print(BOX_DOUBLE.VERTICAL + " ".repeat((width - title.length()) / 2 - 1) + Color.WHITE_BOLD_BRIGHT + title + Color.RESET + " ".repeat((width - title.length()) / 2 + (title.length() % 2) - 1) + BOX_DOUBLE.VERTICAL + "\n");
        System.out.print(verticalLineMiddle + "\n");

        for (int i = 0; i < options.length; i++) {
            String currentOption = options[i];

            System.out.print(BOX_DOUBLE.VERTICAL + " ".repeat((width - currentOption.length()) / 2 - 1) + options[i] + " ".repeat((width - currentOption.length()) / 2 + (currentOption.length() % 2) - 1) + BOX_DOUBLE.VERTICAL + "\n");

            if (i == options.length - 1) {
                System.out.print(verticalLineLower + "\n");
            } else {
                System.out.print(verticalLineMiddle + "\n");
            }
        }
    }

    private static void printMainMenu(String title, String[] options) {
        int width = title.length() * 2;
        String verticalLineUpper = BOX_FAT.CORNER_LEFT_UPPER + (BOX_FAT.HORIZONTAL_UPPER + "").repeat(width - 2) + BOX_FAT.CORNER_RIGHT_UPPER;
        String verticalLineLower = BOX_FAT.CORNER_LEFT_LOWER + (BOX_FAT.HORIZONTAL_LOWER + "").repeat(width - 2) + BOX_FAT.CORNER_RIGHT_LOWER;

        // Print title with box
        System.out.print(verticalLineUpper + "\n");
        System.out.print(BOX_FAT.VERTICAL_LEFT + " ".repeat((width - title.length()) / 2 - 1) + Color.WHITE_BOLD_BRIGHT + title + Color.RESET + " ".repeat((width - title.length()) / 2 + (title.length() % 2) - 1) + BOX_FAT.VERTICAL_RIGHT + "\n");
        System.out.print(verticalLineLower + "\n");

        for (int i = 0; i < options.length; i++) {
            String currentOption = options[i];

            System.out.print(BOX_FAT.VERTICAL_LEFT + " ".repeat((width - currentOption.length()) / 2 - 1) + options[i] + " ".repeat((width - currentOption.length()) / 2 + (currentOption.length() % 2) - 1) + BOX_FAT.VERTICAL_RIGHT + "\n");
            System.out.print(verticalLineLower + "\n");
        }
    }



    public static class BOX_FAT {
        final static char VERTICAL_RIGHT = '▐';
        final static char VERTICAL_LEFT = '▌';
        final static char HORIZONTAL_UPPER = '▀';
        final static char HORIZONTAL_LOWER = '▄';

        final static char CORNER_LEFT_UPPER = '▛';
        final static char CORNER_RIGHT_UPPER = '▜';
        final static char CORNER_LEFT_LOWER = '▙';
        final static char CORNER_RIGHT_LOWER = '▟';
    }

    public static class BOX_DOUBLE {
        final static char VERTICAL = '║';
        final static char HORIZONTAL = '═';
        final static char CORNER_LEFT_UPPER = '╔';
        final static char CORNER_RIGHT_UPPER = '╗';
        final static char CORNER_LEFT_LOWER = '╚';
        final static char CORNER_RIGHT_LOWER = '╝';
        final static char CROSS = '╬';

        final static char CROSS_HALF_LEFT = '╣';
        final static char CROSS_HALF_RIGHT = '╠';
        final static char CROSS_HALF_DOWN = '╦';
        final static char CROSS_HALF_UP = '╩';


    }
}

