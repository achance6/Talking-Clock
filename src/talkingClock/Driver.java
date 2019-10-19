package talkingClock;

import java.util.Scanner;

public final class Driver {
    private Driver() {
    }
    /** Main method.
     * @param args not used.
     */
    public static void main(final String[] args) {
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                clock(args[i]);
            }
        }
        else {
            System.out.println("Enter a time: hh:mm");
            Scanner scnr = new Scanner(System.in);
            while (scnr.hasNext()) {
                clock(scnr.nextLine());
                System.out.println("Enter a time: hh:mm Ctrl-D to exit");
            }
        }

    }

    public static void clock(String input) {
        int h = 0;
        if (input.indexOf(":") != 1) {
            h = Integer.parseInt(input.substring(0, 2));
        }
        else {
            h = Integer.parseInt(input.substring(0, 1));
        }
        int m = Integer.parseInt(input.substring(3));
        String ampm = "am";
        if (h >= 12) {
            ampm = "pm";
            h -= 12;
        }
        String[] tens = {"nothing", "oh", "twenty", "thirty", "forty", "fifty"};
        String[] ones = {"twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
        "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        if (m == 0) {
            System.out.println("It's " + ones[h] + " " + ampm);
        }
        else if (m < 10) {
            System.out.println("It's " + ones[h] + " " + tens[1] + " " + ones[m] + " " + ampm);
        }
        else if (m % 10 == 0) {
            System.out.println("It's " + ones[h] + " " + tens[m / 10] + " " + ampm);
        }
        else {
            System.out.println("It's " + ones[h] + " " + tens[m / 10] + " " + ones[m % 10] + " " + ampm);
        }
    }
}
