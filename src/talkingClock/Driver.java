package talkingClock;

import java.util.Scanner;

public final class Driver {
    //Not used
    private Driver() {
    }
    /** Main method.
     * @param args Optional use of command line to specify times
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

    /**
     *
     * @param input A time of format hh:mm or h:mm
     */
    public static void clock(String input) {
        String[] tens = {"nothing", "oh", "twenty", "thirty", "forty", "fifty"};
        String[] ones = {"twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
                "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        int h = 0;
        int m = 0;
        try {
            if (input.indexOf(":") != 1) { //indicates hh:mm vs h:mm format
                h = Integer.parseInt(input.substring(0, 2));
            } else {
                h = Integer.parseInt(input.substring(0, 1));
            }
            m = Integer.parseInt(input.substring(3));
        }
        catch (NumberFormatException nfe) {
            System.err.println("Invalid input: Usage hh:mm or h:mm");
            return;
        }
        catch (StringIndexOutOfBoundsException sioobe) {
            System.err.println("Invalid input: Usage hh:mm or h:mm");
            return;
        }
        //AM/PM checking
        String ampm = "am";
        if (h >= 12 && h <= 24) {
            ampm = "pm";
            h -= 12;
        }
        //Print the time in words
        try {
            if (m == 0) {
                System.out.println("It's " + ones[h] + " " + ampm);
            } else if (m < 10) {
                System.out.println("It's " + ones[h] + " " + tens[1] + " " + ones[m] + " " + ampm);
            } else if (m % 10 == 0) {
                System.out.println("It's " + ones[h] + " " + tens[m / 10] + " " + ampm);
            } else {
                System.out.println("It's " + ones[h] + " " + tens[m / 10] + " " + ones[m % 10] + " " + ampm);
            }
        }
        catch (IndexOutOfBoundsException ioobe){
            System.err.println("Invalid Hours/Minutes");
            return;
        }
    }
}
